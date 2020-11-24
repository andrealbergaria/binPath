#!/bin/bash

#
A="apacheds/selfSignedCert"
SERVER="bin/certs/server"
CLIENT="bin/certs/client"
APACHEDS="~/workspace/apacheds/selfSignedCert"
# Generate keys

# Limpar pasta com as chaves
rm -rf bin/certs
rm -rf apacheds/selfSignedCert
mkdir -p bin
mkdir -p bin/certs
mkdir -p bin/certs/server
mkdir -p bin/certs/client
mkdir -p apacheds
mkdir -p apacheds/selfSignedCert
# =============================================================================
# Chaves servidor
# =============================================================================

# LDAP
# =============================================================================

# Criar chave privada "ldap.ks" e listar essa chave
keytool -genkeypair -keystore $A/ldap.ks -keypass seg001 -storepass seg001 -keyalg RSA -dname "CN=seg001, OU=seg, O=di, L=fcul, ST=lx, C=pt"
keytool -list -v -keystore $A/ldap.ks -storepass seg001

# Exportar certificado "ldap.cer" e listar certificado
keytool -export -file $A/ldap.cer -keystore $A/ldap.ks -storepass seg001
keytool -v -printcert -file $A/ldap.cer

# Importar certificado "ldap.cer" para uma keystore "trustLDAP.ks"
keytool -import -noprompt -file $A/ldap.cer -keystore $SERVER/trustLDAP.ks -storepass seg001
keytool -list -v -keystore $SERVER/trustLDAP.ks -storepass seg001


# SecureBoxServer
# =============================================================================

# Criar chave privada "server.ks" e listar essa chave
keytool -genkeypair -keystore $SERVER/server.ks -keypass seg001 -storepass seg001 -keyalg RSA -dname "CN=seg001, OU=seg, O=di, L=fcul, ST=lx, C=pt"
keytool -list -v -keystore $SERVER/server.ks -storepass seg001

# Exportar certificado "server.cer" e listar certificado
keytool -export -file $SERVER/server.cer -keystore $SERVER/server.ks -storepass seg001
keytool -v -printcert -file $SERVER/server.cer

# Importar certificado "server.cer" para uma keystore "trustServer.ks" e listar keystore
keytool -import -noprompt -file $SERVER/server.cer -keystore $SERVER/trustServer.ks -storepass seg001
keytool -list -v -keystore $SERVER/trustServer.ks -storepass seg001


# ==============================================================================
# Chave secreta para cifrar ficheiro (AES implementacao bouncy castle) 
# ==============================================================================
keytool -genseckey -alias "secKey" -keyalg AES -keysize 128 -keystore $SERVER/secKey.ks -storetype "JCEKS" -keypass seg001 -storepass seg001
keytool -list -v -keystore $SERVER/secKey.ks -storetype "JCEKS" -storepass seg001

# ==============================================================================
# Chaves clientes
# ==============================================================================

# Explicação - utilizador andre
# ==============================================================================

# Criar keystore "client/<alias>.ks" e listar essa chave
keytool -genkeypair -alias andre -keystore $CLIENT/andre.ks -keypass seg001 -storepass seg001 -keyalg RSA -dname "CN=andre, OU=seg, O=di, L=fcul, ST=lx, C=pt"
keytool -list -v -keystore $CLIENT/andre.ks -storepass seg001

# Importar certificado "server/server.cer" para uma keystore "andre.ks" e listar keystore
keytool -import -noprompt -file $SERVER/server.cer -keystore client/andre.ks -storepass seg001
keytool -list -v -keystore $CLIENT/andre.ks -storepass seg001


# Utilizador fabio
# ==============================================================================
keytool -genkeypair -alias fabio -keystore $CLIENT/fabio.ks -keypass seg001 -storepass seg001 -keyalg RSA -dname "CN=fabio, OU=seg, O=di, L=fcul, ST=lx, C=pt"
keytool -list -v -keystore $CLIENT/fabio.ks -storepass seg001
keytool -import -noprompt -file $SERVER/server.cer -keystore client/fabio.ks -storepass seg001
keytool -list -v -keystore $CLIENT/fabio.ks -storepass seg001


# Utilizador tim
# ==============================================================================
keytool -genkeypair -alias tim -keystore $CLIENT/tim.ks -keypass seg001 -storepass seg001 -keyalg RSA -dname "CN=tim, OU=seg, O=di, L=fcul, ST=lx, C=pt"
keytool -list -v -keystore $CLIENT/tim.ks -storepass seg001
keytool -import -noprompt -file $SERVER/server.cer -keystore client/tim.ks -storepass seg001
keytool -list -v -keystore $CLIENT/tim.ks -storepass seg001

echo "Copying ldap.ks and ldap.cer to $APACHEDS\n"
cp -f ~/workspace/seg2011_proj2/apacheds/selfSignedCert $APACHEDS
