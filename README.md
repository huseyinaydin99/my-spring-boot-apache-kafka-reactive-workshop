# my-spring-boot-apache-kafka-workshop

### Apache Kafka Commands

```
Linux, Unix or macOS
cd kafka_server
bin/zookeeper-server-start.sh config/zookeeper.properties
bin/kafka-server-start.sh config/server.properties
bin/kafka-topics.sh --create --topic quickstart-events --bootstrap-server localhost:9092
bin/kafka-topics.sh --create --topic test-topic --bootstrap-server localhost:9092
bin/kafka-topics.sh --describe --topic quickstart-events --bootstrap-server localhost:9092
bin/kafka-topics.sh --describe --topic test-topic --bootstrap-server localhost:9092
bin/kafka-console-producer.sh --topic quickstart-events --bootstrap-server localhost:9092
bin/kafka-console-consumer.sh --topic quickstart-events --from-beginning --bootstrap-server localhost:9092
```

```
Windows
cd kafka_server
bin/zookeeper-server-start.bat config/zookeeper.properties
bin/kafka-server-start.bat config/server.properties
bin/kafka-topics.bat --create --topic quickstart-events --bootstrap-server localhost:9092
bin/kafka-topics.bat --create --topic test-topic --bootstrap-server localhost:9092
bin/kafka-topics.bat --describe --topic quickstart-events --bootstrap-server localhost:9092
bin/kafka-topics.bat --describe --topic test-topic --bootstrap-server localhost:9092
bin/kafka-console-producer.bat --topic quickstart-events --bootstrap-server localhost:9092
bin/kafka-console-consumer.bat --topic quickstart-events --from-beginning --bootstrap-server localhost:9092
```

### Apache Kafka Nedir?

Ön Bilgi:

Apache Kafka linkedin tarafından geliştirilmiş 2011 yılında ilk sürümü çıkmış açık kaynak bir projedir. Apache Kafka aynı RabbitMQ gibi bir Message Broker sistemidir. Bir mesajı göndericiden alır ardından kuyruğa atar ve alıcıya gönderir. Alıcı da mesajı alıp tüketir. Apache Kafka’da kuyruk mekanizmasından daha fazlası vardır. Linkedin şirketinin fonlamasıyla beraber Jay Kreps önderliğinde geliştirilmiştir. İlk sürüm 2011 yılında piyasaya çıkmıştır.
![res1](https://github.com/huseyinaydin99/my-spring-boot-apache-kafka-reactive-workshop/assets/16438043/f1a510d8-a2ba-407e-9b1d-74ed85834f23)

İsmini 2012 yılında Franz Kafka’dan almıştır.
Jay Kreps yani Kafka’yı geliştiren adam Franz Kafka’nın hayatını inceliyor çalışma stilini, disiplinini çoook beğeniyor ve ürettiği kuyruk mekanizmasına Kafka ismini veriyor. Apache Kafka Scala ve Java dilleri ile yazılmıştır. İçinde bulunan mesajlar Index yapısına göre okunur ve yazılır.
Bundan dolayı performanslı ve hızlı bir sistemdir.
![res2](https://github.com/huseyinaydin99/my-spring-boot-apache-kafka-reactive-workshop/assets/16438043/8f9f315d-bea3-47c8-ba6a-44c634761105)

Apache Kafka’yı nerelerde kullanabiliriz?
1- Web Sayfası Etkinlik İzlemelerinde:
Kullanıcının(user) girdiği aksiyonlar, sayfalar üzerindeki işlemler, oturum verileri(session) gibi yerlerde tutulabilir.
• Bu bilgileri merkezi bir yerde yani Apache Kafka’nın topiklerinde(merkezi depolama birimleri) tutabilirsiniz.
• Bilgiler topik içinde toplanır ve gerçek zamanlı işler için uygun hale getirilebilir.
2- İzleme sistemlerindeki metriklerde:
• Bir sunucunun izlenmesi için yani CPU, RAM, Disk gibi sistem kaynaklarının izlenmesi gibi durumlarda Kafka sıklıkla kullanılır.
3- Log toplama sistemlerinde:
• Kafka çeşitli kaynaklardan log toplama ve bunları işleme sokma gibi durumlar kullanılabilir.
• Örnek olarak bir mobil uygulama düşünelim. Uygulamanın loglarını alıp Apache Kafka’a aktarıp bu loglar için çıkarım yapacak consumer/worker’larla beraber analizler(big data analizi, makine öğrenmesi, tahminlemeler, çıkarımlar vs.) ve işlemler yapabiliriz.
4- Streaming Data:
• Akan verileride yani sürekli alınan verilerde kullanılabilir. Örneğin sürekli veri girişi olan bir uygulama. Sosyal medya vs. gibi.
![res3](https://github.com/huseyinaydin99/my-spring-boot-apache-kafka-reactive-workshop/assets/16438043/556b7c3c-3b39-4a6f-ada0-1f6d1a5aa76a)

Apache Kafka’nın Faydaları:

Rakiplerine göre hızlıdır.
Yüksek trafik ve düşük gecikme sağlıyor.
Yoğun verileri kaldırıp atıyor güçlü bir güreşçinin rakiplerini alt etmesi gibi.
Ölçeklenebilir. Node ve Partition ile yatay olarak ölçeklendirilebilir.
Güvenilirdir çünkü dağıtık ve hata tolere edebilir bir yapısı var.
Veri kaybı yok, mesajlar disk üzerinde immutable log ile yazılıyor.
Immutable log ile yazıldığında mesaj değiştirilemez bunu ancak Kafka değiştirebilir.
Açık kaynak kodlu bir Apache projesi olduğu için bedavadır.
Apache Kafka’yı kullanan bir çok büyük firma vardır.
Bunlar; Netflix, Spotify, Linkedin, Activision.
Apache Kafka Bileşenleri:
• RabbitMQ’a benzer bir yapısı vardır.
• Temelde bir Producer(üretici), bir Kafka Cluster(Topic 1, Topic 2), birde Consumer(tüketici, alıcı) vardır.
![res4](https://github.com/huseyinaydin99/my-spring-boot-apache-kafka-reactive-workshop/assets/16438043/189d8693-658a-43e6-a618-8e6e5ef1dc9b)

Producer Nedir?
• Producer(üretici) bize Kafka’nın toplayacağı verileri üretip gönderen yapıdır. Rast gele sayı üretip Kafka topiğine gönderen bir yapı olabilir. Email göndren bir yapı olabilir. Video upload eden bir yapı olabilir.
• Kafka Cluster’ın içinde Topic’ler vardır. Örneğin Topic 1 ve Topic 2 şeklinde. Tabi biz istediğimiz kadar Topic oluşturabiliriz ihtiyaca göre.
• Kafka Broker ise Topic’leri içinde tutan yapıdır. Aslında her şeyi bu yapı yapar. Sunucunun ta kendisidir. Port numarası olarak default(var sayılan) 9092 portunu kullanır.

Consumer Nedir?
• Consumer ise topic’lere bağlanır/join olur/abone olur ve topiği baştan başlayarak okumaya başlar. Topic’i tüketene kadar sömürür. Kendisi tam bir yiyicidir aynı benim gibi :)
![res5](https://github.com/huseyinaydin99/my-spring-boot-apache-kafka-reactive-workshop/assets/16438043/dac240b6-fc26-4fb6-a35f-90989e043d10)

İşlemler:
İlk yapmamız gereken şey Topic’i üretmektir. Mesela bizim bir tane email topic’i olsun. Bu topic’in amacı sistemde gönderilmesi gereken mailleri toplamaktır. Peki nasıl toplayacak? Producer gönderilecek bildirim maillerini MailTopic’e push/publish/send eder. Gönderilen mesaj 0. Index’ yazılır. Producer gönderilecek kampanya maillerini MailTopic’e push/publish/send eder. Gönderilen mesaj 1. Index’ yazılır. Producer gönderilecek güncelleme maillerini MailTopic’e push/publish/send eder. Gönderilen mesaj 2. Index’ yazılır. Consumer ise şunu yapıyor; gidip ilgili topic’e örneğin MailTopic’e join/subscribe oluyor. Sonrasında ise topic’deki verileri Index sırasına göre tek tek okuyup tüketiyor. Okuma işleminin ardından ilgili topic’de hiç bir şey kalmıyor ve tükeniyor. Dilersek bir topic’i parçalara ayırabiliriz. Bu işleme partitioning deniyor. Örneğin UpdateMail ve NotificationMail diye iki farklı partition olsun. Bunlar MailTopic’in içinde tutulsun. Güncelleme maillerini UpdateMail isimli part’a push/send ederiz. Bildirimleri ise NotificationMail isimli part’a push/send ederiz.
Consumer(tüketici) tarafında ise MultiPartition ile tüketim yapılır. 1'den fazla partition varsa biz sadece örneğin UpdateMail partition’u oku diyoruz teorik olarak. O da gidip UpdateMail partition’u okuyor ve tüketiyor. Bağlı olduğu partition’da bir bilgi kalmayınca duruyor ve yeni bir bilginin gelmesini bekliyor. Bu noktada sanki kuyruk mekanizması gibi davranıyor. Apache Kafka, RabbitMQ’den farklı lanse ediliyor çünkü Apache Kafka hem Queue(kuyruk) hem de Pub/Sub(Publisher/Subscriber) yani abone olunan ve abone olan modellerini aynı anda birlikte sunuyor. Bu diğerlerinden en önemli farkıdır.
![res6](https://github.com/huseyinaydin99/my-spring-boot-apache-kafka-reactive-workshop/assets/16438043/f9ac2b2e-e6da-45ff-830b-12b8e960cf73)

Queue(kuyruk) nedir? Mesaj bir kere publish(göndermek/paylaşmak) edilir 1 kere consumer(tüketici) tarafından consume(tüketilir). Consume işlemi bitince kuyruktaki mesajlar tükenir, biter.
![res7](https://github.com/huseyinaydin99/my-spring-boot-apache-kafka-reactive-workshop/assets/16438043/6974a450-9096-43cd-9b21-d52f432617e4)

Pub/Sub Nedir?

Mesaj bir defa publish edildikten sonra defalarca consume edilebilir. Consume edildi diye silinmez. YouTube gibi düşünebiliriz abone olunan ve abone olan şeklinde. Consume edildikten sonra Pubsisher’e geri bildirim gönderilir.
![res8](https://github.com/huseyinaydin99/my-spring-boot-apache-kafka-reactive-workshop/assets/16438043/c20791a4-c3d1-40d5-98bf-7c098ba8cd3b)

Consume Group(tüketici grubu) Nedir?:

Partitionların paralel olarak işlenmesi için kullanılır. 1 consumer 1 partition okumaktan sorumludur(olması gereken budur). Örnek; bir tane Kafka Cluster’ımız var. Portu 9092 diyelim. Cluster’da UpdateMail isimli Topic’imiz olsun. Bu topic 2 farklı partition’a bölünsün Partition 1 ve Partition 2 şeklinde. Bir tanede Consumer Group’umuz olsun. Şimdilik içi boş. Consumer Group’umuzun içinde de 2 tane consumer olsun Consumer 1 ve Consumer 2 şeklinde. Consumer Group’umuz UpdateMail topic’ine join oluyor. Consumer Group’umuzun içindeki Consumer 1 UpdateMail Topic’inin içindeki Partition 1 ve Partition 2'ye join olsun.
— — — — — — — — —
PART1| PART2
0. Abc | 0. Aaa
1. Cba | 1. Vfc
2. Xce | 2. yzx
Consumer 1 okurken paralel olarak okuyor yani; 0. Abc, 0. Aaa | 1. CbA, 1. Vfc | 2. Xce, 2. yzx | şeklinde 0 0 - 1 1 - 2 2 şeklinde Index numarasına göre paralel okur. Sorun olmayabilr ama bu durum biraz aykırı bir durum.
Sorun olmamasının sebeplerinden birisi Consumer iyi makine üzerinde çalışıyor olabilir. İyi bir load balancer vardır yükü iyi dağıttığı için sorun olmuyordur. İdeal ve olması gereken; 1 partition 1 consumer tarafından okunmalıdır. Daha doğru senaryo şöyle olmalıdır.
Bir producer, bir Kafka Cluster, bir Consumer Group ve o Consumer Group’un içinde iki tane Consumer. Consumer 1, Partition 1'i Consumer 2 ise Partition 2'yi okusun. Bu daha iyi ve temiz bir senaryodur. Consumer 1 okumayı bitirince Partition 1'e bakmaz. Consumer 2'de aynı şekilde okumayı bitirince Partition 2'ye bakmaz. İkisi yani Consumer 1 ve 2 aynı anda paralel olarak okumaya başlar ve Queue(kuyruk) gibi davranır.
Consume Group Pub/Sub(tüketici grubu) davranışı:
Bir Producer, bir Kafka Broker, Kafka Broker’in içinde de 1 Topic, o Topic’in içinde de 1 Partition ve 3 tane Consumer Group düşünelim. Bu durumda Consumer Group 1, 2 ve 3 aynı anda Partition 1'in 0. Index’ini okur. Okunan Index silinir. Ardıdan 2 ve 3 aynı şekilde devam eder… Bu senaryoda bir kere publish ediyoruz 3 farklı kaynaktan okuyoruz. Buna Pub/Sub modeli deniyor.
![res9](https://github.com/huseyinaydin99/my-spring-boot-apache-kafka-reactive-workshop/assets/16438043/79d55a1f-f1c9-423a-a8e2-eb5e2f16911f)
Queue gibi davranmasını istiyorsak tüm Consumer’leri tek Consumer Group’a koymamız gerekir. Pub/Sub gibi davranmasını istiyorsak her bir Consumer’i kendine ait başka bir Consumer Group içine koymalıyız.

Topic Bazlı Dağıtık Sistem(Disturbuted System) Nedir?
Bir Kafka sunucu düşünelim. İçinde bir Topic var. O Topic’inde içinde 2 farklı Partition bulunsun. Elimizde başka sunucularda var örneğin 4 sunucu daha olsun. Bu dört sunucuda 1. sunucunun bire bir kopyaları olsun. Okuma yaparken zaten bir şey kaybetmeyiz. Yazma işleminde ise yine bir şey kaybedilmez. 1. sunucuya veriyi yazınca diğerleride veriyi alır.
Bu şekilde aklımızda kabaca kalsa yeterli. Bu durumda tıpkı internet kafe gibi diğer bilgisayarları yöneten ana makina olur. Ana makinaya Master(efendi), diğer makinalara ise Slave(kul, köle) deniliyor. Ana makina diğerlerine hükmediyor. Kafka’da bu durumda ana makinaya Leader(lider) Slave(köle) yani clone(kopya) olanlara ise Follower(takipçi) deniliyor. Veriler yazılırken Leader’e yazılır daha sonrasında ise Follower’a kopyalanır. Ana kaynak Leader’dir.
Peki ya Leader sunucu çökerse ne olacak? Veri Leader’e yazılamaz bu durumda. O zaman bu durum veri kaybı demektir. Apache Kafka işte bu durumu engellemek için Partition bazlı disturbuted(dağıtık) sistemede destek veriyor. Kafka Cluster 1'de 2 partition olsun. Kafka Cluster 2'de aynı şekilde kopya 2 partition olsun. Bu durum da Kafka Cluster 1'de Partition 1 Leader olur ve Kafka Cluster 2'de Partition 2 Leader olur.
![res10](https://github.com/huseyinaydin99/my-spring-boot-apache-kafka-reactive-workshop/assets/16438043/d2080038-7828-4fc2-a592-5bac6a40d2cc)

Apache Zookeeper Nedir?

Kafka’nın çalışması için bir gerekliliktir. Kafka’daki bilgilerin stabil bir şekilde tutulmasını sağlıyor ve Kafka Cluster’e bağlı bir şekilde çalışıyor. Kafka’yı çalıştırırken önce Zookeeper çalıştırılır. Kafka, Zookeeper’a bağımlıdır. Zookeeper hayvanat bahçesi bakıcısı demektir. Yani bir ekosistemin yöneticisi anlamındadır.
![res11](https://github.com/huseyinaydin99/my-spring-boot-apache-kafka-reactive-workshop/assets/16438043/f4d6b69f-d893-4c32-8599-f3ef57a0ff6e)

Gossip Protokolü Nedir?
1 Producer, 2 Kafka Cluster, her Cluster’da 2 Partition ve 1 Consumer olsun. Producer, Kafka Cluster’ın Partition 2'e bir tane Mail push etsin. Bu durumda gönderilem mail Leader olan Partition’a yazılır. Peki biz Leader olanı nasıl bileceğizde göndereceğiz? Böyle bir durumda Leader olanı bilmemize gerek yoktur, bizim yerimize Apache Zookeeper biliyor. Zookeeper Leader olan Partition’u bulabilmek adına Cluster’larla ve Partition’larla kendi aralarında konuştukları için Gossip Protocol denmiş. Gossip kelime anlamı olarak dedikodu demektir. Leader dedikodu ve konuşma sonrası tespit edilip bilgi Leader’e yazılıyor sonrasında ise Follower’lara kopyalanıyor.
![res12](https://github.com/huseyinaydin99/my-spring-boot-apache-kafka-reactive-workshop/assets/16438043/1cfd0884-25a8-45eb-bdf5-31ec816e49ac)

Kafka Kurulumu:

İndirme adresi: https://kafka.apache.org/downloads
İlgili adresten 2.5.0 sürümünü indiriniz. Ben bu sürümü tercih ediyorum. Zipten C:\ dizinin içine Winrar programı ile çıkartınız. MacOS işletim düzeninde farklı olabilir zipten çıkarma.

```
Zookeeper’i çalıştırır: çıkartılan klasör/bin/windows/zookeeper-server-start.bat
Zookeeper’i configure eder: çıkartılan klasör/bin/config/zookeeper.properties

Kafka Server’ı çalıştırır: çıkartılan klasör/bin/windows/kafka-server-start.bat
Kafka’yı configure eder: çıkartılan klasör/bin/config/server.properties
$> zookeeper-server-start.bat zookeeper.properties //ilgili properties config dosyası ile zookeeperi start eder.
$> C:\kafka\bin\windows\zookeeper-server-start.bat C:\kafka\config\zookeeper.properties //yol vererek zookeeper start etme işlemidir.
$: C:\kafka\bin\windows\kafka-server-start.bat C:\kafka\config\server.properties //kafkayı varsayılan ayarlarda çalıştırır. Ayarlar server.properties dosyasında yapılır. Port değiştirme vs…
$: C:\kafka\bin\windows\kafka-server-start.bat C:\kafka\config\server2.properties //Kafkayı özel ayarlarla çalıştırır. Ayarla server2.properties dosyasında yapılır. server2.properties dosyası kendiliğinden yok siz server.properties dosyasından kopyalayınız.
$: C:\kafka\bin\windows\kafka-topics.bat - bootstrap-server localhost:9092 - create - topic topic1 //Kafka topici oluşturur. Oluşan topicin ismi topic1.
$: C:\kafka\bin\windows\kafka-topics.bat - bootstrap-server localhost:9092 - partitions 10 - replication-factor 2 - create - topic topic2 //topic 2 üzerinde 10 partition'lu replika(kopya) faktörü 2 olan topic'i oluşturur.
$: C:\kafka\bin\windows\kafka-topics.bat - bootstrap-server localhost:9092 - describe - create - topic topic3 //topic3 isimli topici oluşturur ve açıklamasını verir.
$: C:\kafka\bin\windows\kafka-topics.bat - bootstrap-server localhost:9092 - delete - create - topic topic3 //topic3 isimli topici siler.
$: C:\kafka\bin\windows\kafka-console-consumer.bat - bootstrap-server localhost:9092 - topic topic2 //topic2 isimli topici dinlemeye alıyor gelen giden var mı bakıyor.
$: C:\kafka\bin\windows\kafka-console-producer.bat - bootstrap-server localhost:9092 - topic topic2 //topic2ye mesaj gönderebilmemiz için gerekli olan komuttur.
$: C:\kafka\bin\windows\kafka-consumer-groups.bat - bootstrap-server localhost:9092 - list //tüketici gruplarını(consumer groupları listeler)
//console-consumer-57896
$: C:\kafka\bin\windows\kafka-consumer-groups.bat - bootstrap-server localhost:9092 - describe - group console-consumer-57896
```

Docker üzerinden Apache Kafka kullanımı:
Docker’ın kurulu olduğunu varsayıyorum. Apache Kafka’yı kullanabilmemiz için öncelikle Zookeeper’in ayakta olması lazım.

```
$: docker run - name zookeeper -p 2181:2181 zookeeper //komutu zookeeperin imagesini pull eder yani indirir ve çalıştırır. Bu işlemi ayrı terminalde yapınız.
$: docker run - name kafka -p 9092:9092 -e KAFKA_ZOOKEEPER_CONNECT=192.168.1.101:2181 -e KAFKA_ADVERTISED_LISTENERS=PLAINTEXT://192.168.1.101:9092 -e KAFKA_OFFSETS_TOPIC_REPLICATION_FACTOR=1 confluentinc/cp-kafka //Kafkayı ve Zookeeperı birbirine IP numarası ve portları ile bağlayıp çalıştırdık. Bu işlemi ayrı terminalde yapınız.
$: docker exec -it kafka sh //container üzerinden shell(kabuk-işletim sisteminin çekirdeğine komutlar girip donanım üzerinde kernelin işlemler(process) yürütebilmesi için terinal yada arayüz) aldık. Bu işlemi ayrı terminalde yapınız.
$: kafka-topics - bootstrap-server localhost:9092 - create - topic topic1 //topic1i oluşturduk.
$: kafka-console-consumer - bootstrap-server localhost:9092 - topic topic1 //topic1i dinlemeye aldık consume edebilmek için. //Bu işlemi ayrı terminalde yapınız.
$: kafka-console-producer - bootstrap-server localhost:9092 - topic topic1 //topic1e mesajlar gönderelim. //Bu işlemi ayrı terminalde yapınız.
>selam
>merhaba
//Diğer dinleyici terminalden gözlemleyiniz.
```

Hepsi bu kadar umarım faydalı olur.

Teşekkürler.
