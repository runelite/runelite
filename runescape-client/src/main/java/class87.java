import java.applet.Applet;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ck")
public class class87 {
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "Lip;"
   )
   public static IndexDataBase field1392;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -989869689
   )
   int field1389;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1895250863
   )
   int field1396;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -1188294673
   )
   int field1391;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1224095481
   )
   int field1390;
   @ObfuscatedName("g")
   String field1393;

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Ljava/applet/Applet;Ljava/lang/String;I)V",
      garbageValue = "-1879759706"
   )
   public static void method1721(Applet var0, String var1) {
      class56.field693 = var0;
      class56.field692 = var1;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(ILct;ZB)I",
      garbageValue = "120"
   )
   static int method1720(int var0, Script var1, boolean var2) {
      if(var0 == 5630) {
         Client.field977 = 250;
         return 1;
      } else {
         return 2;
      }
   }

   @ObfuscatedName("hh")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-173605239"
   )
   @Export("groundItemSpawned")
   static final void groundItemSpawned(int var0, int var1) {
      Deque var2 = Client.groundItemDeque[class46.plane][var0][var1];
      if(var2 == null) {
         class3.region.method2738(class46.plane, var0, var1);
      } else {
         long var3 = -99999999L;
         Item var5 = null;

         Item var6;
         for(var6 = (Item)var2.getFront(); var6 != null; var6 = (Item)var2.getNext()) {
            ItemComposition var7 = FaceNormal.getItemDefinition(var6.id);
            long var8 = (long)var7.price;
            if(var7.isStackable == 1) {
               var8 *= (long)(var6.quantity + 1);
            }

            if(var8 > var3) {
               var3 = var8;
               var5 = var6;
            }
         }

         if(var5 == null) {
            class3.region.method2738(class46.plane, var0, var1);
         } else {
            var2.addTail(var5);
            Item var11 = null;
            Item var10 = null;

            for(var6 = (Item)var2.getFront(); var6 != null; var6 = (Item)var2.getNext()) {
               if(var6.id != var5.id) {
                  if(var11 == null) {
                     var11 = var6;
                  }

                  if(var6.id != var11.id && var10 == null) {
                     var10 = var6;
                  }
               }
            }

            int var9 = var0 + (var1 << 7) + 1610612736;
            class3.region.addItemPile(class46.plane, var0, var1, class41.getTileHeight(var0 * 128 + 64, var1 * 128 + 64, class46.plane), var5, var9, var11, var10);
         }
      }
   }
}
