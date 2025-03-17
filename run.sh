#!/bin/bash

echo "🚀 CORBA Demo: Derleme ve Başlatma"

# 1️⃣ Eski derlemeleri temizle
echo "🧹 Temizleme işlemi..."
rm -rf bin
mkdir -p bin

# 2️⃣ Java dosyalarını derle
echo "🛠️  Derleme yapılıyor..."
javac -d bin $(find src/main/java -name "*.java")

# 3️⃣ ORBD servisini başlat (CORBA)
echo "🔵 ORBD başlatılıyor..."
orbd -ORBInitialPort 900 &  
sleep 2  

# 4️⃣ BServer'ı başlat
echo "🔵 BServer başlatılıyor..."
java -cp bin appB.server.BServer &

# 5️⃣ 2 saniye bekle, sonra AServer'ı başlat
sleep 2
echo "🟢 AServer başlatılıyor..."
java -cp bin appA.server.AServer &

# 6️⃣ 2 saniye bekle, sonra AClient çalıştır
sleep 2
echo "💻 AClient çalıştırılıyor..."
java -cp bin appA.AClient


echo "✅ Tüm işlemler tamamlandı."
