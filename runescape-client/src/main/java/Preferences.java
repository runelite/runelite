import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ca")
@Implements("Preferences")
public class Preferences {
   @ObfuscatedName("ri")
   @ObfuscatedGetter(
      intValue = 2136835161
   )
   static int field1243;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -193880735
   )
   static int field1237;
   @ObfuscatedName("o")
   @Export("hideRoofs")
   boolean hideRoofs;
   @ObfuscatedName("j")
   @Export("muted")
   boolean muted;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1125088693
   )
   @Export("screenType")
   int screenType;
   @ObfuscatedName("x")
   @Export("rememberedUsername")
   String rememberedUsername;
   @ObfuscatedName("z")
   @Export("hideUsername")
   boolean hideUsername;
   @ObfuscatedName("p")
   @Export("preferences")
   LinkedHashMap preferences;

   static {
      field1237 = 6;
   }

   Preferences() {
      this.screenType = 1;
      this.rememberedUsername = null;
      this.hideUsername = false;
      this.preferences = new LinkedHashMap();
      this.method1646(true);
   }

   @ObfuscatedSignature(
      signature = "(Lgp;)V"
   )
   Preferences(Buffer var1) {
      this.screenType = 1;
      this.rememberedUsername = null;
      this.hideUsername = false;
      this.preferences = new LinkedHashMap();
      if(var1 != null && var1.payload != null) {
         int var2 = var1.readUnsignedByte();
         if(var2 >= 0 && var2 <= field1237) {
            if(var1.readUnsignedByte() == 1) {
               this.hideRoofs = true;
            }

            if(var2 > 1) {
               this.muted = var1.readUnsignedByte() == 1;
            }

            if(var2 > 3) {
               this.screenType = var1.readUnsignedByte();
            }

            if(var2 > 2) {
               int var3 = var1.readUnsignedByte();

               for(int var4 = 0; var4 < var3; ++var4) {
                  int var5 = var1.readInt();
                  int var6 = var1.readInt();
                  this.preferences.put(Integer.valueOf(var5), Integer.valueOf(var6));
               }
            }

            if(var2 > 4) {
               this.rememberedUsername = var1.getNullString();
            }

            if(var2 > 5) {
               this.hideUsername = var1.method3526();
            }
         } else {
            this.method1646(true);
         }
      } else {
         this.method1646(true);
      }

   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "-1727294059"
   )
   void method1646(boolean var1) {
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)Lgp;",
      garbageValue = "717909734"
   )
   @Export("serialize")
   Buffer serialize() {
      Buffer var1 = new Buffer(100);
      var1.putByte(field1237);
      var1.putByte(this.hideRoofs?1:0);
      var1.putByte(this.muted?1:0);
      var1.putByte(this.screenType);
      var1.putByte(this.preferences.size());
      Iterator var2 = this.preferences.entrySet().iterator();

      while(var2.hasNext()) {
         Entry var3 = (Entry)var2.next();
         var1.putInt(((Integer)var3.getKey()).intValue());
         var1.putInt(((Integer)var3.getValue()).intValue());
      }

      var1.putString(this.rememberedUsername != null?this.rememberedUsername:"");
      var1.writeBooleanAsByte(this.hideUsername);
      return var1;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-1342344850"
   )
   static int method1645(int var0, int var1) {
      ItemContainer var2 = (ItemContainer)ItemContainer.itemContainers.get((long)var0);
      return var2 == null?0:(var1 >= 0 && var1 < var2.stackSizes.length?var2.stackSizes[var1]:0);
   }

   @ObfuscatedName("hn")
   @ObfuscatedSignature(
      signature = "(IIIIIB)V",
      garbageValue = "1"
   )
   @Export("drawObject")
   static final void drawObject(int var0, int var1, int var2, int var3, int var4) {
      int var5 = class308.region.getWallObjectHash(var0, var1, var2);
      int var6;
      int var7;
      int var8;
      int var9;
      int var11;
      int var12;
      if(var5 != 0) {
         var6 = class308.region.getObjectFlags(var0, var1, var2, var5);
         var7 = var6 >> 6 & 3;
         var8 = var6 & 31;
         var9 = var3;
         if(var5 > 0) {
            var9 = var4;
         }

         int[] var10 = ServerPacket.minimapSprite.pixels;
         var11 = var1 * 4 + (103 - var2) * 2048 + 24624;
         var12 = var5 >> 14 & 32767;
         ObjectComposition var13 = FileRequest.getObjectDefinition(var12);
         if(var13.mapSceneId != -1) {
            IndexedSprite var14 = class61.mapscene[var13.mapSceneId];
            if(var14 != null) {
               int var15 = (var13.width * 4 - var14.width) / 2;
               int var16 = (var13.length * 4 - var14.height) / 2;
               var14.method5842(var15 + var1 * 4 + 48, (104 - var2 - var13.length) * 4 + var16 + 48);
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

      var5 = class308.region.method2904(var0, var1, var2);
      if(var5 != 0) {
         var6 = class308.region.getObjectFlags(var0, var1, var2, var5);
         var7 = var6 >> 6 & 3;
         var8 = var6 & 31;
         var9 = var5 >> 14 & 32767;
         ObjectComposition var23 = FileRequest.getObjectDefinition(var9);
         int var18;
         if(var23.mapSceneId != -1) {
            IndexedSprite var17 = class61.mapscene[var23.mapSceneId];
            if(var17 != null) {
               var12 = (var23.width * 4 - var17.width) / 2;
               var18 = (var23.length * 4 - var17.height) / 2;
               var17.method5842(var12 + var1 * 4 + 48, var18 + (104 - var2 - var23.length) * 4 + 48);
            }
         } else if(var8 == 9) {
            var11 = 15658734;
            if(var5 > 0) {
               var11 = 15597568;
            }

            int[] var22 = ServerPacket.minimapSprite.pixels;
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

      var5 = class308.region.getGroundObjectHash(var0, var1, var2);
      if(var5 != 0) {
         var6 = var5 >> 14 & 32767;
         ObjectComposition var19 = FileRequest.getObjectDefinition(var6);
         if(var19.mapSceneId != -1) {
            IndexedSprite var20 = class61.mapscene[var19.mapSceneId];
            if(var20 != null) {
               var9 = (var19.width * 4 - var20.width) / 2;
               int var21 = (var19.length * 4 - var20.height) / 2;
               var20.method5842(var9 + var1 * 4 + 48, var21 + (104 - var2 - var19.length) * 4 + 48);
            }
         }
      }

   }
}
