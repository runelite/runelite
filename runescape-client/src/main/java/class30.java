import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("af")
public class class30 {
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 972970541
   )
   int field687 = 1;
   @ObfuscatedName("i")
   boolean field690;
   @ObfuscatedName("c")
   LinkedHashMap field691 = new LinkedHashMap();
   @ObfuscatedName("a")
   boolean field692;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 903890537
   )
   static int field695 = 4;
   @ObfuscatedName("mo")
   @Export("clanMembers")
   static XClanMember[] clanMembers;

   class30(Buffer var1) {
      if(null != var1 && null != var1.payload) {
         int var2 = var1.readUnsignedByte();
         if(var2 >= 0 && var2 <= field695) {
            if(var1.readUnsignedByte() == 1) {
               this.field690 = true;
            }

            if(var2 > 1) {
               this.field692 = var1.readUnsignedByte() == 1;
            }

            if(var2 > 3) {
               this.field687 = var1.readUnsignedByte();
            }

            if(var2 > 2) {
               int var3 = var1.readUnsignedByte();

               for(int var4 = 0; var4 < var3; ++var4) {
                  int var5 = var1.method2780();
                  int var6 = var1.method2780();
                  this.field691.put(Integer.valueOf(var5), Integer.valueOf(var6));
               }
            }
         } else {
            this.method663(true);
         }
      } else {
         this.method663(true);
      }

   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "1855712610"
   )
   void method663(boolean var1) {
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(IZIZB)V",
      garbageValue = "53"
   )
   static void method666(int var0, boolean var1, int var2, boolean var3) {
      if(null != World.worldList) {
         GroundObject.method1498(0, World.worldList.length - 1, var0, var1, var2, var3);
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)LBuffer;",
      garbageValue = "762323845"
   )
   Buffer method668() {
      Buffer var1 = new Buffer(100);
      var1.method2760(field695);
      var1.method2760(this.field690?1:0);
      var1.method2760(this.field692?1:0);
      var1.method2760(this.field687);
      var1.method2760(this.field691.size());
      Iterator var2 = this.field691.entrySet().iterator();

      while(var2.hasNext()) {
         Entry var3 = (Entry)var2.next();
         var1.method2763(((Integer)var3.getKey()).intValue());
         var1.method2763(((Integer)var3.getValue()).intValue());
      }

      return var1;
   }

   class30() {
      this.method663(true);
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Lclass159;IB)Z",
      garbageValue = "-54"
   )
   static boolean method673(class159 var0, int var1) {
      int var2 = var0.method3032(2);
      int var3;
      int var4;
      int var7;
      int var8;
      int var9;
      int var10;
      if(var2 == 0) {
         if(var0.method3032(1) != 0) {
            method673(var0, var1);
         }

         var3 = var0.method3032(6);
         var4 = var0.method3032(6);
         boolean var12 = var0.method3032(1) == 1;
         if(var12) {
            class45.field904[++class45.field895 - 1] = var1;
         }

         if(null != Client.cachedPlayers[var1]) {
            throw new RuntimeException();
         } else {
            Player var6 = Client.cachedPlayers[var1] = new Player();
            var6.field244 = var1;
            if(null != class45.field887[var1]) {
               var6.method214(class45.field887[var1]);
            }

            var6.field650 = class45.field883[var1];
            var6.interacting = class45.field894[var1];
            var7 = class45.field889[var1];
            var8 = var7 >> 28;
            var9 = var7 >> 14 & 255;
            var10 = var7 & 255;
            var6.field656[0] = class45.field886[var1];
            var6.field261 = (byte)var8;
            var6.method218(var3 + (var9 << 6) - FrameMap.baseX, (var10 << 6) + var4 - XItemContainer.baseY);
            var6.field263 = false;
            return true;
         }
      } else if(var2 == 1) {
         var3 = var0.method3032(2);
         var4 = class45.field889[var1];
         class45.field889[var1] = ((var3 + (var4 >> 28) & 3) << 28) + (var4 & 268435455);
         return false;
      } else {
         int var5;
         int var11;
         if(var2 == 2) {
            var3 = var0.method3032(5);
            var4 = var3 >> 3;
            var5 = var3 & 7;
            var11 = class45.field889[var1];
            var7 = (var11 >> 28) + var4 & 3;
            var8 = var11 >> 14 & 255;
            var9 = var11 & 255;
            if(var5 == 0) {
               --var8;
               --var9;
            }

            if(var5 == 1) {
               --var9;
            }

            if(var5 == 2) {
               ++var8;
               --var9;
            }

            if(var5 == 3) {
               --var8;
            }

            if(var5 == 4) {
               ++var8;
            }

            if(var5 == 5) {
               --var8;
               ++var9;
            }

            if(var5 == 6) {
               ++var9;
            }

            if(var5 == 7) {
               ++var8;
               ++var9;
            }

            class45.field889[var1] = (var8 << 14) + (var7 << 28) + var9;
            return false;
         } else {
            var3 = var0.method3032(18);
            var4 = var3 >> 16;
            var5 = var3 >> 8 & 255;
            var11 = var3 & 255;
            var7 = class45.field889[var1];
            var8 = var4 + (var7 >> 28) & 3;
            var9 = var5 + (var7 >> 14) & 255;
            var10 = var11 + var7 & 255;
            class45.field889[var1] = var10 + (var9 << 14) + (var8 << 28);
            return false;
         }
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(II)Lclass187;",
      garbageValue = "-1479227043"
   )
   public static class187 method674(int var0) {
      class187 var1 = (class187)class187.field2752.get((long)var0);
      if(null != var1) {
         return var1;
      } else {
         byte[] var2 = class187.field2751.method3272(16, var0);
         var1 = new class187();
         if(null != var2) {
            var1.method3415(new Buffer(var2));
         }

         class187.field2752.put(var1, (long)var0);
         return var1;
      }
   }
}
