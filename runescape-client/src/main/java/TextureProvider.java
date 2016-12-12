import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Insets;
import java.net.URL;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bo")
@Implements("TextureProvider")
public class TextureProvider implements class93 {
   @ObfuscatedName("e")
   Deque field1202 = new Deque();
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -601354215
   )
   int field1203;
   @ObfuscatedName("i")
   class79[] field1204;
   @ObfuscatedName("g")
   double field1205 = 1.0D;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -659475639
   )
   int field1206 = 128;
   @ObfuscatedName("a")
   class182 field1207;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1419716747
   )
   int field1210 = 0;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(D)V",
      garbageValue = "0.9"
   )
   public void method1414(double var1) {
      this.field1205 = var1;
      this.method1418();
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(II)[I",
      garbageValue = "366616288"
   )
   @Export("load")
   public int[] load(int var1) {
      class79 var2 = this.field1204[var1];
      if(var2 != null) {
         if(null != var2.field1315) {
            this.field1202.method2355(var2);
            var2.field1309 = true;
            return var2.field1315;
         }

         boolean var3 = var2.method1533(this.field1205, this.field1206, this.field1207);
         if(var3) {
            if(this.field1210 == 0) {
               class79 var4 = (class79)this.field1202.method2372();
               var4.method1530();
            } else {
               --this.field1210;
            }

            this.field1202.method2355(var2);
            var2.field1309 = true;
            return var2.field1315;
         }
      }

      return null;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(IB)I",
      garbageValue = "1"
   )
   public int vmethod1872(int var1) {
      return null != this.field1204[var1]?this.field1204[var1].field1305:0;
   }

   @ObfuscatedSignature(
      signature = "(Lclass182;Lclass182;IDI)V",
      garbageValue = "64"
   )
   public TextureProvider(class182 var1, class182 var2, int var3, double var4, int var6) {
      this.field1207 = var2;
      this.field1203 = var3;
      this.field1210 = this.field1203;
      this.field1205 = var4;
      this.field1206 = var6;
      int[] var7 = var1.method3289(0);
      int var8 = var7.length;
      this.field1204 = new class79[var1.method3220(0)];

      for(int var9 = 0; var9 < var8; ++var9) {
         Buffer var10 = new Buffer(var1.method3211(0, var7[var9]));
         this.field1204[var7[var9]] = new class79(var10);
      }

   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-558539187"
   )
   public boolean vmethod1874(int var1) {
      return this.field1206 == 64;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "154777343"
   )
   public void method1418() {
      for(int var1 = 0; var1 < this.field1204.length; ++var1) {
         if(null != this.field1204[var1]) {
            this.field1204[var1].method1530();
         }
      }

      this.field1202 = new Deque();
      this.field1210 = this.field1203;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "7"
   )
   public void method1419(int var1) {
      for(int var2 = 0; var2 < this.field1204.length; ++var2) {
         class79 var3 = this.field1204[var2];
         if(var3 != null && var3.field1307 != 0 && var3.field1309) {
            var3.method1531(var1);
            var3.field1309 = false;
         }
      }

   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-791006817"
   )
   static void method1423() {
      int var0 = GameEngine.field1773;
      int var1 = GameEngine.field1774;
      int var2 = class118.field1849 - ItemLayer.field1223 - var0;
      int var3 = class104.field1679 - class112.field1755 - var1;
      if(var0 > 0 || var2 > 0 || var1 > 0 || var3 > 0) {
         try {
            Container var4 = Client.field282.method2084();
            int var5 = 0;
            int var6 = 0;
            if(var4 == class164.field2162) {
               Insets var7 = class164.field2162.getInsets();
               var5 = var7.left;
               var6 = var7.top;
            }

            Graphics var9 = var4.getGraphics();
            var9.setColor(Color.black);
            if(var0 > 0) {
               var9.fillRect(var5, var6, var0, class104.field1679);
            }

            if(var1 > 0) {
               var9.fillRect(var5, var6, class118.field1849, var1);
            }

            if(var2 > 0) {
               var9.fillRect(var5 + class118.field1849 - var2, var6, var2, class104.field1679);
            }

            if(var3 > 0) {
               var9.fillRect(var5, class104.field1679 + var6 - var3, class118.field1849, var3);
            }
         } catch (Exception var8) {
            ;
         }
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1643880073"
   )
   @Export("loadWorlds")
   static boolean loadWorlds() {
      try {
         if(class6.worldServersDownload == null) {
            class6.worldServersDownload = new class26(class41.field855, new URL(class3.field33));
         } else {
            byte[] var0 = class6.worldServersDownload.method557();
            if(var0 != null) {
               Buffer var1 = new Buffer(var0);
               World.field672 = var1.readUnsignedShort();
               class107.worldList = new World[World.field672];

               World var3;
               for(int var2 = 0; var2 < World.field672; var3.index = var2++) {
                  var3 = class107.worldList[var2] = new World();
                  var3.id = var1.readUnsignedShort();
                  var3.mask = var1.method2844();
                  var3.address = var1.method2767();
                  var3.activity = var1.method2767();
                  var3.location = var1.readUnsignedByte();
                  var3.playerCount = var1.method2762();
               }

               class142.method2646(class107.worldList, 0, class107.worldList.length - 1, World.field678, World.field674);
               class6.worldServersDownload = null;
               return true;
            }
         }
      } catch (Exception var4) {
         var4.printStackTrace();
         class6.worldServersDownload = null;
      }

      return false;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(IIB)I",
      garbageValue = "-81"
   )
   static final int method1437(int var0, int var1) {
      int var2 = class116.method2207(var0 - 1, var1 - 1) + class116.method2207(1 + var0, var1 - 1) + class116.method2207(var0 - 1, 1 + var1) + class116.method2207(1 + var0, 1 + var1);
      int var3 = class116.method2207(var0 - 1, var1) + class116.method2207(1 + var0, var1) + class116.method2207(var0, var1 - 1) + class116.method2207(var0, 1 + var1);
      int var4 = class116.method2207(var0, var1);
      return var3 / 8 + var2 / 16 + var4 / 4;
   }

   @ObfuscatedName("dw")
   @ObfuscatedSignature(
      signature = "(IIIILSpritePixels;Lclass164;I)V",
      garbageValue = "995675923"
   )
   static final void method1444(int var0, int var1, int var2, int var3, SpritePixels var4, class164 var5) {
      int var6 = var2 * var2 + var3 * var3;
      if(var6 > 4225 && var6 < 90000) {
         int var7 = Client.mapScale + Client.mapAngle & 2047;
         int var8 = class84.field1453[var7];
         int var9 = class84.field1454[var7];
         var8 = var8 * 256 / (256 + Client.mapScaleDelta);
         var9 = var9 * 256 / (Client.mapScaleDelta + 256);
         int var10 = var3 * var8 + var2 * var9 >> 16;
         int var11 = var9 * var3 - var8 * var2 >> 16;
         double var12 = Math.atan2((double)var10, (double)var11);
         int var14 = (int)(Math.sin(var12) * 63.0D);
         int var15 = (int)(Math.cos(var12) * 57.0D);
         class63.field1095.method4023(var0 + 94 + var14 + 4 - 10, var1 + 83 - var15 - 20, 20, 20, 15, 15, var12, 256);
      } else {
         NPC.method675(var0, var1, var2, var3, var4, var5);
      }

   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-367641042"
   )
   public boolean vmethod1875(int var1) {
      return this.field1204[var1].field1308;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(II)LNPCComposition;",
      garbageValue = "787163752"
   )
   @Export("getNpcDefinition")
   public static NPCComposition getNpcDefinition(int var0) {
      NPCComposition var1 = (NPCComposition)NPCComposition.field3000.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = NPCComposition.field3004.method3211(9, var0);
         var1 = new NPCComposition();
         var1.id = var0;
         if(null != var2) {
            var1.method3630(new Buffer(var2));
         }

         var1.method3653();
         NPCComposition.field3000.put(var1, (long)var0);
         return var1;
      }
   }
}
