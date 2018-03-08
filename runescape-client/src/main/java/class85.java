import java.io.File;
import java.math.BigInteger;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cr")
public class class85 {
   @ObfuscatedName("l")
   static final BigInteger field1289;
   @ObfuscatedName("b")
   static final BigInteger field1290;
   @ObfuscatedName("n")
   public static boolean field1294;
   @ObfuscatedName("cd")
   @ObfuscatedGetter(
      intValue = -2124586831
   )
   public static int field1295;
   @ObfuscatedName("du")
   @ObfuscatedGetter(
      intValue = 855908717
   )
   @Export("myWorldPort")
   static int myWorldPort;

   static {
      field1289 = new BigInteger("80782894952180643741752986186714059433953886149239752893425047584684715842049");
      field1290 = new BigInteger("7237300117305667488707183861728052766358166655052137727439795191253340127955075499635575104901523446809299097934591732635674173519120047404024393881551683");
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Ljava/io/File;B)V",
      garbageValue = "-64"
   )
   public static void method1908(File var0) {
      class170.field2189 = var0;
      if(!class170.field2189.exists()) {
         throw new RuntimeException("");
      } else {
         class170.field2194 = true;
      }
   }
}
