{{- define "app.annotation" -}}
devexp.ngdc/app.code: {{ .Values.app.code | quote }}
devexp.ngdc/app.description: {{ .Chart.Description | quote }}
devexp.ngdc/app.version: {{ .Values.app.version | quote }}
{{- end -}}