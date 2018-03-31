import java.math.BigInteger;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cj")
public class class85 {
   @ObfuscatedName("k")
   static final BigInteger field1302;
   @ObfuscatedName("x")
   static final BigInteger field1305;

   static {
      field1302 = new BigInteger("80782894952180643741752986186714059433953886149239752893425047584684715842049");
      field1305 = new BigInteger("7237300117305667488707183861728052766358166655052137727439795191253340127955075499635575104901523446809299097934591732635674173519120047404024393881551683");
   }

   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      signature = "(Ldd;I)V",
      garbageValue = "-2057926383"
   )
   static final void method1842(TaskDataNode var0) {
      var0.field1638 = false;
      if(var0.data != null) {
         var0.data.int1 = 0;
      }

      for(TaskDataNode var1 = var0.vmethod4336(); var1 != null; var1 = var0.vmethod4337()) {
         method1842(var1);
      }

   }
}
