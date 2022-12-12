# KeytoComponent
Split the cryptographic key into 2 or 3 components


Master키를 2, 3 Component로 분할해주는 도구
반출키 분리를 위한 내부사용 (상대기관에서 Component지원하지 않을 경우 제공)

A tool that divides the master key into 2, 3 components
Internal use for export key separation (provided when the other organization does not support the component)


Example)

java -jar KeyToComponent.jar
BRUCELEE-M-2E8C24:keytool_v1.1 bruce.lee$ java -jar KeyToComponent.jar


Bruce.lee Cipher key Component Tool



Input Masterkey
11112222333344445555666677778888

MasterKey(32 Char): 11112222333344445555666677778888

[3 Component]

Component 1(32 Char): 2F0D1D5F65E05F881FE9CE9C9218BEE1   KCV(AES)  DF1330
Component 2(32 Char): F661B668F2E1E07866239DC629D353EB   KCV(AES)  DD8874
Component 3(32 Char): C87D8915A432FBB42C9F353CCCBC6582   KCV(AES)  042097

Combined Key(32 Char): 11112222333344445555666677778888   KCV(AES)  F0C03E

[2 Component]

Component 1(32 Char): 2F0D1D5F65E05F881FE9CE9C9218BEE1   KCV(AES)  DF1330
Component 2(32 Char): 3E1C3F7D56D31BCC4ABCA8FAE56F3669   KCV(AES)  AEACEF

Combined Key(32 Char): 11112222333344445555666677778888   KCV(AES)  F0C03E

BRUCELEE-M-2E8C24:keytool_v1.1 bruce.lee$
