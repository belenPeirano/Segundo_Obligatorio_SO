package so.segundoobligatorio;

import java.util.LinkedHashMap;

public class ColaMultiNivel<K, V> {

    private LinkedHashMap<K, V>[] colaMultiNivel;
    private int ultimoNivel;
    private long tamanio;

    public ColaMultiNivel(final int niveles) {
        this.colaMultiNivel = new LinkedHashMap[niveles + 1];
        for (int i = 0; i <= niveles; ++i) {
            this.colaMultiNivel[i] = new LinkedHashMap<K, V>();
        }
        this.ultimoNivel = niveles;
        this.tamanio = 0L;
    }

    public LinkedHashMap<K, V>[] getColaMultiNivel() {
        return colaMultiNivel;
    }

    public long getTamanio() {
        return tamanio;
    }
    
    public V remover(final K clave) {
        LinkedHashMap<K, V>[] colaMultiNivel;
        for (int length = (colaMultiNivel = this.colaMultiNivel).length, i = 0; i < length; ++i) {
            final LinkedHashMap<K, V> colaNivel = colaMultiNivel[i];
            if (colaNivel.containsKey(clave)) {
                --this.tamanio;
                return colaNivel.remove(clave);
            }
        }
        return null;
    }

    public V remover(final K clave, final int nivel) {
        if (this.nivelValido(nivel) && this.colaMultiNivel[nivel].containsKey(clave)) {
            --this.tamanio;
            return this.colaMultiNivel[nivel].remove(clave);
        }
        return null;
    }

    public V agregar(final K clave, final V value, final int nivel) {
        if (nivelValido(nivel)) {
            ultimoNivel = Math.min(ultimoNivel, nivel);
            ++tamanio;
            return colaMultiNivel[nivel].put(clave, value);
        }
        return null;
    }

    private boolean nivelValido(final int nivel) {
        return nivel < colaMultiNivel.length && nivel >= 0;
    }
    
    public V obtenerClave(final K clave) {
        LinkedHashMap<K, V>[] colaMultiNivel = this.colaMultiNivel;
        for (int i = 0; i < colaMultiNivel.length; i++) {
            final LinkedHashMap<K, V> colaNivel = colaMultiNivel[i];
            if (colaNivel.containsKey(clave)) {
                return colaNivel.get(clave);
            }
        }
        return null;
    }
    
    public V siguiente() {
        if (this.esVacia()) {
            return null;
        }
        while (this.ultimoNivel < this.colaMultiNivel.length) {
            if (!this.colaMultiNivel[this.ultimoNivel].isEmpty()) {
                final K clave = this.colaMultiNivel[this.ultimoNivel].keySet().iterator().next();
                return this.remover(clave, this.ultimoNivel);
            }
            ++this.ultimoNivel;
        }
        this.ultimoNivel = 0;
        return null;
    }
    
    public boolean esVacia() {
        return this.tamanio == 0L;
    }

}