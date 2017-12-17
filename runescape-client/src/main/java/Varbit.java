import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jw")
@Implements("Varbit")
public class Varbit extends CacheableNode {
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lib;"
   )
   @Export("varbit_ref")
   public static IndexDataBase varbit_ref;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lgu;"
   )
   @Export("varbits")
   public static NodeCache varbits;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 988632729
   )
   static int field3462;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1005831171
   )
   @Export("configId")
   public int configId;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 442861105
   )
   @Export("leastSignificantBit")
   public int leastSignificantBit;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 1796470167
   )
   @Export("mostSignificantBit")
   public int mostSignificantBit;

   static {
      varbits = new NodeCache(64);
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Lgh;B)V",
      garbageValue = "8"
   )
   @Export("decode")
   public void decode(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.readNext(var1, var2);
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Lgh;IB)V",
      garbageValue = "101"
   )
   @Export("readNext")
   void readNext(Buffer var1, int var2) {
      if(var2 == 1) {
         this.configId = var1.readUnsignedShort();
         this.leastSignificantBit = var1.readUnsignedByte();
         this.mostSignificantBit = var1.readUnsignedByte();
      }

   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-18"
   )
   public static void method4570(int var0) {
      if(var0 != -1) {
         if(class115.validInterfaces[var0]) {
            class37.widgetIndex.method4327(var0);
            if(Widget.widgets[var0] != null) {
               boolean var1 = true;

               for(int var2 = 0; var2 < Widget.widgets[var0].length; ++var2) {
                  if(Widget.widgets[var0][var2] != null) {
                     if(Widget.widgets[var0][var2].type != 2) {
                        Widget.widgets[var0][var2] = null;
                     } else {
                        var1 = false;
                     }
                  }
               }

               if(var1) {
                  Widget.widgets[var0] = null;
               }

               class115.validInterfaces[var0] = false;
            }
         }
      }
   }
}
