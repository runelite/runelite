import java.math.BigInteger;
import java.util.Iterator;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ce")
public class class85 {
   @ObfuscatedName("e")
   static final BigInteger field1293;
   @ObfuscatedName("y")
   static final BigInteger field1296;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1591504475
   )
   static int field1299;

   static {
      field1293 = new BigInteger("80782894952180643741752986186714059433953886149239752893425047584684715842049");
      field1296 = new BigInteger("7237300117305667488707183861728052766358166655052137727439795191253340127955075499635575104901523446809299097934591732635674173519120047404024393881551683");
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "17"
   )
   static void method1886() {
      Iterator var0 = class95.messages.iterator();

      while(var0.hasNext()) {
         MessageNode var1 = (MessageNode)var0.next();
         var1.method1123();
      }

   }

   @ObfuscatedName("ju")
   @ObfuscatedSignature(
      signature = "(Liw;I)I",
      garbageValue = "2043976024"
   )
   @Export("getWidgetConfig")
   static int getWidgetConfig(Widget var0) {
      IntegerNode var1 = (IntegerNode)Client.widgetFlags.get((long)var0.index + ((long)var0.id << 32));
      return var1 != null?var1.value:var0.config;
   }
}
