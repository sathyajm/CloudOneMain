Write-Host -ForegroundColor Green @"
-------------------------------------------------------
prerequisite to run this testrunner, install following
- docker
- source-to-image (https://github.com/openshift/source-to-image)
- maven
- Configure docker and maven to work with repo.east1.ncloud.netapp.com  

To clear port conflict from stray docker run, execute following
@(docker ps -aq) | ForEach-Object{docker rm -f $_}
-------------------------------------------------------
"@

$SOURCE_DIR = if ($null -eq $SOURCE_DIR) { "source" } else { $SOURCE_DIR }
$S2I_BUILDER = if ($null -eq $SOURCS2I_BUILDERE_DIR) { "docker-ngdc.repo.east1.ncloud.netapp.com/openjdk/openjdk-11-rhel7:1.0" } else { $S2I_BUILDER }
$S2I_SRC = if ($null -eq $S2I_SRC) { "source/target" } else { $S2I_SRC }

#make clean
Write-Host -ForegroundColor Yellow "mvn clean package"
mvn -f $SOURCE_DIR/pom.xml -DfinalName=springboot clean package

#docker pull builder image
Write-Host -ForegroundColor Yellow   "docker pull builder $S2I_BUILDER"
docker pull $S2I_BUILDER

#s2i build
Write-Host -ForegroundColor Yellow   "run s2i build"
s2i build ${S2I_SRC} $S2I_BUILDER testrunner
@(docker ps -aq) | ForEach-Object{docker rm -f $_}

#docker run as deamon
Write-Host -ForegroundColor Yellow   "run testrunner as deamon"
docker run --rm --name testrunner -d -p 8080:8080 testrunner

#run test
Write-Host -ForegroundColor Yellow   "Point your browser to http://localhost:8080 for manual testing"
#Start-Process -FilePath "http://localhost:8080"
Write-Host -ForegroundColor Yellow   "Ctrl-C to exit"
docker attach testrunner