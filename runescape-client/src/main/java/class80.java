import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cv")
public final class class80 extends Node {
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lhn;"
   )
   static Deque field1247;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1838436081
   )
   int field1243;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -738087771
   )
   int field1245;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -288132915
   )
   int field1253;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1785472541
   )
   int field1246;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -326663139
   )
   int field1250;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -508290323
   )
   int field1252;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1386284263
   )
   int field1249;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1290350625
   )
   int field1248;
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "Ldn;"
   )
   class115 field1251;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 124688107
   )
   int field1256;
   @ObfuscatedName("o")
   int[] field1254;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -746647815
   )
   int field1255;
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Ljs;"
   )
   ObjectComposition field1257;
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Ldn;"
   )
   class115 field1244;

   static {
      field1247 = new Deque();
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "602747017"
   )
   void method1845() {
      int var1 = this.field1248;
      ObjectComposition var2 = this.field1257.getImpostor();
      if(var2 != null) {
         this.field1248 = var2.ambientSoundId;
         this.field1249 = var2.int4 * 128;
         this.field1252 = var2.int5;
         this.field1256 = var2.int6;
         this.field1254 = var2.field3639;
      } else {
         this.field1248 = -1;
         this.field1249 = 0;
         this.field1252 = 0;
         this.field1256 = 0;
         this.field1254 = null;
      }

      if(var1 != this.field1248 && this.field1251 != null) {
         BoundingBox2D.field238.method2167(this.field1251);
         this.field1251 = null;
      }

   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(II)Ljs;",
      garbageValue = "-286798082"
   )
   @Export("getObjectDefinition")
   public static ObjectComposition getObjectDefinition(int var0) {
      ObjectComposition var1 = (ObjectComposition)ObjectComposition.objects.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = ObjectComposition.objects_ref.getConfigData(6, var0);
         var1 = new ObjectComposition();
         var1.id = var0;
         if(var2 != null) {
            var1.decode(new Buffer(var2));
         }

         var1.post();
         if(var1.isHollow) {
            var1.clipType = 0;
            var1.blocksProjectile = false;
         }

         ObjectComposition.objects.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("hb")
   @ObfuscatedSignature(
      signature = "(IIIIII)V",
      garbageValue = "807144447"
   )
   @Export("drawObject")
   static final void drawObject(int var0, int var1, int var2, int var3, int var4) {
      int var5 = GameSocket.region.getWallObjectHash(var0, var1, var2);
      int var6;
      int var7;
      int var8;
      int var9;
      int var11;
      int var12;
      if(var5 != 0) {
         var6 = GameSocket.region.getObjectFlags(var0, var1, var2, var5);
         var7 = var6 >> 6 & 3;
         var8 = var6 & 31;
         var9 = var3;
         if(var5 > 0) {
            var9 = var4;
         }

         int[] var10 = class44.minimapSprite.pixels;
         var11 = var1 * 4 + (103 - var2) * 2048 + 24624;
         var12 = var5 >> 14 & 32767;
         ObjectComposition var13 = getObjectDefinition(var12);
         if(var13.mapSceneId != -1) {
            IndexedSprite var14 = class2.mapscene[var13.mapSceneId];
            if(var14 != null) {
               int var15 = (var13.width * 4 - var14.width) / 2;
               int var16 = (var13.length * 4 - var14.height) / 2;
               var14.method5898(var15 + var1 * 4 + 48, var16 + (104 - var2 - var13.length) * 4 + 48);
            }
         } else {
            if(var8 == 0 || var8 == 2) {
               if(var7 == 0) {
                  var10[var11] = var9;
                  var10[var11 + 512] = var9;
                  var10[var11 + 1024] = var9;
                  var10[var11 + 1536] = var9;
               } else if(var7 == 1) {
                  var10[var11] = var9;
                  var10[var11 + 1] = var9;
                  var10[var11 + 2] = var9;
                  var10[var11 + 3] = var9;
               } else if(var7 == 2) {
                  var10[var11 + 3] = var9;
                  var10[var11 + 512 + 3] = var9;
                  var10[var11 + 1024 + 3] = var9;
                  var10[var11 + 1536 + 3] = var9;
               } else if(var7 == 3) {
                  var10[var11 + 1536] = var9;
                  var10[var11 + 1536 + 1] = var9;
                  var10[var11 + 1536 + 2] = var9;
                  var10[var11 + 1536 + 3] = var9;
               }
            }

            if(var8 == 3) {
               if(var7 == 0) {
                  var10[var11] = var9;
               } else if(var7 == 1) {
                  var10[var11 + 3] = var9;
               } else if(var7 == 2) {
                  var10[var11 + 1536 + 3] = var9;
               } else if(var7 == 3) {
                  var10[var11 + 1536] = var9;
               }
            }

            if(var8 == 2) {
               if(var7 == 3) {
                  var10[var11] = var9;
                  var10[var11 + 512] = var9;
                  var10[var11 + 1024] = var9;
                  var10[var11 + 1536] = var9;
               } else if(var7 == 0) {
                  var10[var11] = var9;
                  var10[var11 + 1] = var9;
                  var10[var11 + 2] = var9;
                  var10[var11 + 3] = var9;
               } else if(var7 == 1) {
                  var10[var11 + 3] = var9;
                  var10[var11 + 512 + 3] = var9;
                  var10[var11 + 1024 + 3] = var9;
                  var10[var11 + 1536 + 3] = var9;
               } else if(var7 == 2) {
                  var10[var11 + 1536] = var9;
                  var10[var11 + 1536 + 1] = var9;
                  var10[var11 + 1536 + 2] = var9;
                  var10[var11 + 1536 + 3] = var9;
               }
            }
         }
      }

      var5 = GameSocket.region.method2974(var0, var1, var2);
      if(var5 != 0) {
         var6 = GameSocket.region.getObjectFlags(var0, var1, var2, var5);
         var7 = var6 >> 6 & 3;
         var8 = var6 & 31;
         var9 = var5 >> 14 & 32767;
         ObjectComposition var23 = getObjectDefinition(var9);
         int var18;
         if(var23.mapSceneId != -1) {
            IndexedSprite var17 = class2.mapscene[var23.mapSceneId];
            if(var17 != null) {
               var12 = (var23.width * 4 - var17.width) / 2;
               var18 = (var23.length * 4 - var17.height) / 2;
               var17.method5898(var12 + var1 * 4 + 48, var18 + (104 - var2 - var23.length) * 4 + 48);
            }
         } else if(var8 == 9) {
            var11 = 15658734;
            if(var5 > 0) {
               var11 = 15597568;
            }

            int[] var22 = class44.minimapSprite.pixels;
            var18 = var1 * 4 + (103 - var2) * 2048 + 24624;
            if(var7 != 0 && var7 != 2) {
               var22[var18] = var11;
               var22[var18 + 1 + 512] = var11;
               var22[var18 + 1024 + 2] = var11;
               var22[var18 + 1536 + 3] = var11;
            } else {
               var22[var18 + 1536] = var11;
               var22[var18 + 1 + 1024] = var11;
               var22[var18 + 512 + 2] = var11;
               var22[var18 + 3] = var11;
            }
         }
      }

      var5 = GameSocket.region.getGroundObjectHash(var0, var1, var2);
      if(var5 != 0) {
         var6 = var5 >> 14 & 32767;
         ObjectComposition var19 = getObjectDefinition(var6);
         if(var19.mapSceneId != -1) {
            IndexedSprite var20 = class2.mapscene[var19.mapSceneId];
            if(var20 != null) {
               var9 = (var19.width * 4 - var20.width) / 2;
               int var21 = (var19.length * 4 - var20.height) / 2;
               var20.method5898(var1 * 4 + var9 + 48, var21 + (104 - var2 - var19.length) * 4 + 48);
            }
         }
      }

   }

   @ObfuscatedName("kz")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "10"
   )
   static final void method1844() {
      PacketNode var0 = AbstractSoundSystem.method2350(ClientPacket.field2440, Client.field911.field1460);
      var0.packetBuffer.putByte(0);
      Client.field911.method2135(var0);
   }
}
