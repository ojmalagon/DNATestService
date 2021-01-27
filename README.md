# DNATestService
Evalua una secuencia de ADN para saber si es o no mutante e incluye estadísticas

<p>Prerequisitos:</p>
<p>Instalar Eclipse IDE : <a href="https://www.eclipse.org/downloads/download.php?file=/oomph/epp/2020-12/R/eclipse-inst-jre-win64.exe">https://www.eclipse.org/downloads/download.php?file=/oomph/epp/2020-12/R/eclipse-inst-jre-win64.exe</a></p>
<p>Adicionar desde Eclipse Marketplace &ldquo;Spring Tools 4&rdquo;:</p>
<p>Pasos para la ejecuci&oacute;n</p>
<ol>
<li>Clonar el repositorio <a href="https://github.com/ojmalagon/DNATestService.git">https://github.com/ojmalagon/DNATestService.git</a></li>
<li>Importar el proyecto DNATestService/DNATestService en eclipse</li>
<li>Esperar que se descarguen todas las dependencias y librer&iacute;as.</li>
<li>Configurar o verificar la conexi&oacute;n a la BD MongoDB, a trav&eacute;s del archivo application.properties (debe estar disponible para tr&aacute;fico el puerto 27017).</li>
<li>Ejecutarlo: hacer clic derecho sobre el proyecto y seleccionar &ldquo;Run AS/Spring Boot App&rdquo;</li>
</ol>
<p>Nota: verificar que el puerto 8080 se encuentre disponible, de lo contrario ajustar la clase &ldquo;DnaTestServiceApplication&rdquo; contenida en el paquete co.com.dnatest; con el siguiente c&oacute;digo:</p>
<p><em>@SpringBootApplication</em></p>
<p><em>public class DnaTestServiceApplication {</em></p>
<p><em>&nbsp;&nbsp;&nbsp; public static void main(String[] args) {</em></p>
<p><em>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; SpringApplication app = new SpringApplication(DnaTestServiceApplication.class);</em></p>
<p><em>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; app.setDefaultProperties(Collections</em></p>
<p><em>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; .singletonMap("server.port", "8083"));</em></p>
<p><em>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; app.run(args);</em></p>
<p><em>&nbsp;&nbsp;&nbsp; }</em></p>
<p><em>}</em></p>
<p>&nbsp;</p>
<ol start="6">
<li>Con un cliente para servicios REST (recomendado POSTMAN) probar los m&eacute;todos:</li>
</ol>
<p><em>POST-&gt; http://localhost:8080/mutant/</em></p>
<p><em>{</em></p>
<p><em>"dna":["AGGTGGG",&nbsp;"AAGTGC",&nbsp;"AAAAGT",&nbsp;"AGGGGG",&nbsp;"CGCCGA",&nbsp;"TCACTG"]</em></p>
<p><em>}</em></p>
<p><em>GET-&gt; http://localhost:8080/stats</em></p>
