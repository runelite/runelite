import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("aj")
public class class30 {
   @ObfuscatedName("x")
   boolean field685;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 137882583
   )
   static int field686 = 4;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1124111899
   )
   int field687 = 1;
   @ObfuscatedName("k")
   LinkedHashMap field688 = new LinkedHashMap();
   @ObfuscatedName("aa")
   static class102 field690;
   @ObfuscatedName("q")
   boolean field693;

   class30(Buffer var1) {
      if(var1 != null && var1.payload != null) {
         int var2 = var1.readUnsignedByte();
         if(var2 >= 0 && var2 <= field686) {
            if(var1.readUnsignedByte() == 1) {
               this.field685 = true;
            }

            if(var2 > 1) {
               this.field693 = var1.readUnsignedByte() == 1;
            }

            if(var2 > 3) {
               this.field687 = var1.readUnsignedByte();
            }

            if(var2 > 2) {
               int var3 = var1.readUnsignedByte();

               for(int var4 = 0; var4 < var3; ++var4) {
                  int var5 = var1.method2819();
                  int var6 = var1.method2819();
                  this.field688.put(Integer.valueOf(var5), Integer.valueOf(var6));
               }
            }
         } else {
            this.method659(true);
         }
      } else {
         this.method659(true);
      }

   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)LBuffer;",
      garbageValue = "2066164774"
   )
   Buffer method656() {
      Buffer var1 = new Buffer(100);
      var1.method2799(field686);
      var1.method2799(this.field685?1:0);
      var1.method2799(this.field693?1:0);
      var1.method2799(this.field687);
      var1.method2799(this.field688.size());
      Iterator var2 = this.field688.entrySet().iterator();

      while(var2.hasNext()) {
         Entry var3 = (Entry)var2.next();
         var1.method2802(((Integer)var3.getKey()).intValue());
         var1.method2802(((Integer)var3.getValue()).intValue());
      }

      return var1;
   }

   @ObfuscatedName("bz")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "3"
   )
   static void method657(int var0, int var1) {
      Client.field394.method3037(195);
      Client.field394.method2845(var1);
      Client.field394.method2847(var0);
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "1403452314"
   )
   void method659(boolean var1) {
   }

   class30() {
      this.method659(true);
   }

   @ObfuscatedName("bl")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "1496945233"
   )
   @Export("xteaChanged")
   static final void xteaChanged(boolean var0) {
      Client.isDynamicRegion = var0;
      int var1;
      int var2;
      int var3;
      int var4;
      int var5;
      int var6;
      int var7;
      if(!Client.isDynamicRegion) {
         var1 = Client.field323.method2827();
         var2 = Client.field323.method2827();
         var3 = Client.field323.readUnsignedShort();
         class207.xteaKeys = new int[var3][4];

         for(var4 = 0; var4 < var3; ++var4) {
            for(var5 = 0; var5 < 4; ++var5) {
               class207.xteaKeys[var4][var5] = Client.field323.method2819();
            }
         }

         ItemLayer.mapRegions = new int[var3];
         class11.field110 = new int[var3];
         Renderable.field1542 = new int[var3];
         class139.field1936 = new byte[var3][];
         class18.field193 = new byte[var3][];
         boolean var13 = false;
         if((var1 / 8 == 48 || var1 / 8 == 49) && var2 / 8 == 48) {
            var13 = true;
         }

         if(var1 / 8 == 48 && var2 / 8 == 148) {
            var13 = true;
         }

         var3 = 0;

         for(var5 = (var1 - 6) / 8; var5 <= (6 + var1) / 8; ++var5) {
            for(var6 = (var2 - 6) / 8; var6 <= (6 + var2) / 8; ++var6) {
               var7 = var6 + (var5 << 8);
               if(!var13 || var6 != 49 && var6 != 149 && var6 != 147 && var5 != 50 && (var5 != 49 || var6 != 47)) {
                  ItemLayer.mapRegions[var3] = var7;
                  class11.field110[var3] = Client.field309.method3276("m" + var5 + "_" + var6);
                  Renderable.field1542[var3] = Client.field309.method3276("l" + var5 + "_" + var6);
                  ++var3;
               }
            }
         }

         Actor.method598(var1, var2);
      } else {
         var1 = Client.field323.readUnsignedShort();
         var2 = Client.field323.method2827();
         var3 = Client.field323.readUnsignedShort();
         Client.field323.method3054();

         for(var4 = 0; var4 < 4; ++var4) {
            for(var5 = 0; var5 < 13; ++var5) {
               for(var6 = 0; var6 < 13; ++var6) {
                  var7 = Client.field323.method3061(1);
                  if(var7 == 1) {
                     Client.field340[var4][var5][var6] = Client.field323.method3061(26);
                  } else {
                     Client.field340[var4][var5][var6] = -1;
                  }
               }
            }
         }

         Client.field323.method3043();
         class207.xteaKeys = new int[var3][4];

         for(var4 = 0; var4 < var3; ++var4) {
            for(var5 = 0; var5 < 4; ++var5) {
               class207.xteaKeys[var4][var5] = Client.field323.method2819();
            }
         }

         ItemLayer.mapRegions = new int[var3];
         class11.field110 = new int[var3];
         Renderable.field1542 = new int[var3];
         class139.field1936 = new byte[var3][];
         class18.field193 = new byte[var3][];
         var3 = 0;

         for(var4 = 0; var4 < 4; ++var4) {
            for(var5 = 0; var5 < 13; ++var5) {
               for(var6 = 0; var6 < 13; ++var6) {
                  var7 = Client.field340[var4][var5][var6];
                  if(var7 != -1) {
                     int var8 = var7 >> 14 & 1023;
                     int var9 = var7 >> 3 & 2047;
                     int var10 = var9 / 8 + (var8 / 8 << 8);

                     int var11;
                     for(var11 = 0; var11 < var3; ++var11) {
                        if(ItemLayer.mapRegions[var11] == var10) {
                           var10 = -1;
                           break;
                        }
                     }

                     if(var10 != -1) {
                        ItemLayer.mapRegions[var3] = var10;
                        var11 = var10 >> 8 & 255;
                        int var12 = var10 & 255;
                        class11.field110[var3] = Client.field309.method3276("m" + var11 + "_" + var12);
                        Renderable.field1542[var3] = Client.field309.method3276("l" + var11 + "_" + var12);
                        ++var3;
                     }
                  }
               }
            }
         }

         Actor.method598(var2, var1);
      }

   }
}
