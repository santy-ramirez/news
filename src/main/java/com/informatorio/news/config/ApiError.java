package com.informatorio.news.config;
import org.springframework.http.HttpStatus;

import java.util.List;

public class ApiError {

        private HttpStatus status;
        private String mensaje;
        private int cantidadDeErrores;

        private List<ApiSubError> subError;

        public HttpStatus getStatus() {
            return status;
        }

        public void setStatus(HttpStatus status) {
            this.status = status;
        }

        public String getMensaje() {
            return mensaje;
        }

        public void setMensaje(String mensaje) {
            this.mensaje = mensaje;
        }

        public int getCantidadDeErrores() {
            return cantidadDeErrores;
        }

        public void setCantidadDeErrores(int cantidadDeErrores) {
            this.cantidadDeErrores = cantidadDeErrores;
        }

    public List<ApiSubError> getSubError() {
        return subError;
    }

    public void setSubError(List<ApiSubError> subError) {
        this.subError = subError;
    }


}
