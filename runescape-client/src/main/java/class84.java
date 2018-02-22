import java.math.BigInteger;
import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cx")
public class class84 {
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Llv;"
   )
   static IndexedSprite field1264;
   @ObfuscatedName("a")
   static final BigInteger field1263;
   @ObfuscatedName("h")
   static final BigInteger field1258;

   static {
      field1263 = new BigInteger("80782894952180643741752986186714059433953886149239752893425047584684715842049");
      field1258 = new BigInteger("7237300117305667488707183861728052766358166655052137727439795191253340127955075499635575104901523446809299097934591732635674173519120047404024393881551683");
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-742934256"
   )
   public static int method1853() {
      return ++MouseInput.mouseIdleTicks - 1;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "84"
   )
   static void method1854() {
      Iterator var0 = class94.messages.iterator();

      while(var0.hasNext()) {
         MessageNode var1 = (MessageNode)var0.next();
         var1.method1150();
      }

   }

   @ObfuscatedName("km")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)Ljava/lang/String;",
      garbageValue = "-1426010552"
   )
   static String method1848(String var0) {
      Permission[] var1 = class34.method395();

      for(int var2 = 0; var2 < var1.length; ++var2) {
         Permission var3 = var1[var2];
         if(var3.field3293 != -1) {
            int var6 = var3.field3293;
            String var5 = "<img=" + var6 + ">";
            if(var0.startsWith(var5)) {
               var0 = var0.substring(6 + Integer.toString(var3.field3293).length());
               break;
            }
         }
      }

      return var0;
   }
}
