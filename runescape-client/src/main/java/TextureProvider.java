import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("di")
@Implements("TextureProvider")
public class TextureProvider implements ITextureLoader {
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Lij;"
   )
   @Export("widgetIndex")
   public static IndexDataBase widgetIndex;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lil;"
   )
   @Export("currentRequest")
   static FileRequest currentRequest;
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "[Lds;"
   )
   @Export("textures")
   Texture[] textures;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lgg;"
   )
   @Export("deque")
   Deque deque;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -165003691
   )
   @Export("maxSize")
   int maxSize;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1104459195
   )
   @Export("size")
   int size;
   @ObfuscatedName("x")
   @Export("brightness")
   double brightness;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1903660457
   )
   @Export("width")
   int width;
   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "Lij;"
   )
   @Export("sprites")
   IndexDataBase sprites;

   @ObfuscatedSignature(
      signature = "(Lij;Lij;IDI)V"
   )
   public TextureProvider(IndexDataBase var1, IndexDataBase var2, int var3, double var4, int var6) {
      this.deque = new Deque();
      this.size = 0;
      this.brightness = 1.0D;
      this.width = 128;
      this.sprites = var2;
      this.maxSize = var3;
      this.size = this.maxSize;
      this.brightness = var4;
      this.width = var6;
      int[] var7 = var1.getChilds(0);
      int var8 = var7.length;
      this.textures = new Texture[var1.fileCount(0)];

      for(int var9 = 0; var9 < var8; ++var9) {
         Buffer var10 = new Buffer(var1.getConfigData(0, var7[var9]));
         this.textures[var7[var9]] = new Texture(var10);
      }

   }

   @ObfuscatedName("b")
   @Export("brightness")
   public void brightness(double var1) {
      this.brightness = var1;
      this.reset();
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(IB)[I",
      garbageValue = "0"
   )
   @Export("load")
   public int[] load(int var1) {
      Texture var2 = this.textures[var1];
      if(var2 != null) {
         if(var2.pixels != null) {
            this.deque.addTail(var2);
            var2.loaded = true;
            return var2.pixels;
         }

         boolean var3 = var2.method2497(this.brightness, this.width, this.sprites);
         if(var3) {
            if(this.size == 0) {
               Texture var4 = (Texture)this.deque.popTail();
               var4.resetPixels();
            } else {
               --this.size;
            }

            this.deque.addTail(var2);
            var2.loaded = true;
            return var2.pixels;
         }
      }

      return null;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(IB)I",
      garbageValue = "1"
   )
   @Export("getAverageTextureRGB")
   public int getAverageTextureRGB(int var1) {
      return this.textures[var1] != null?this.textures[var1].field1787:0;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "299358493"
   )
   public boolean vmethod2893(int var1) {
      return this.textures[var1].field1783;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-2027405994"
   )
   public boolean vmethod2885(int var1) {
      return this.width == 64;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1273515737"
   )
   @Export("reset")
   public void reset() {
      for(int var1 = 0; var1 < this.textures.length; ++var1) {
         if(this.textures[var1] != null) {
            this.textures[var1].resetPixels();
         }
      }

      this.deque = new Deque();
      this.size = this.maxSize;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "30"
   )
   public void method2394(int var1) {
      for(int var2 = 0; var2 < this.textures.length; ++var2) {
         Texture var3 = this.textures[var2];
         if(var3 != null && var3.field1789 != 0 && var3.loaded) {
            var3.method2499(var1);
            var3.loaded = false;
         }
      }

   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(ILcx;ZI)I",
      garbageValue = "-578214629"
   )
   static int method2415(int var0, Script var1, boolean var2) {
      if(var0 == 3300) {
         class82.intStack[++class82.intStackSize - 1] = Client.gameCycle;
         return 1;
      } else {
         int var3;
         int var4;
         int[] var5;
         int var6;
         int var7;
         ItemContainer var8;
         if(var0 == 3301) {
            class82.intStackSize -= 2;
            var3 = class82.intStack[class82.intStackSize];
            var4 = class82.intStack[class82.intStackSize + 1];
            var5 = class82.intStack;
            var6 = ++class82.intStackSize - 1;
            var8 = (ItemContainer)ItemContainer.itemContainers.get((long)var3);
            if(var8 == null) {
               var7 = -1;
            } else if(var4 >= 0 && var4 < var8.itemIds.length) {
               var7 = var8.itemIds[var4];
            } else {
               var7 = -1;
            }

            var5[var6] = var7;
            return 1;
         } else if(var0 == 3302) {
            class82.intStackSize -= 2;
            var3 = class82.intStack[class82.intStackSize];
            var4 = class82.intStack[class82.intStackSize + 1];
            class82.intStack[++class82.intStackSize - 1] = class47.method663(var3, var4);
            return 1;
         } else if(var0 == 3303) {
            class82.intStackSize -= 2;
            var3 = class82.intStack[class82.intStackSize];
            var4 = class82.intStack[class82.intStackSize + 1];
            class82.intStack[++class82.intStackSize - 1] = class211.method3849(var3, var4);
            return 1;
         } else {
            int var10;
            if(var0 == 3304) {
               var3 = class82.intStack[--class82.intStackSize];
               int[] var9 = class82.intStack;
               var10 = ++class82.intStackSize - 1;
               InvType var11 = (InvType)InvType.inventoryCache.get((long)var3);
               InvType var12;
               if(var11 != null) {
                  var12 = var11;
               } else {
                  byte[] var13 = InvType.field3336.getConfigData(5, var3);
                  var11 = new InvType();
                  if(var13 != null) {
                     var11.decode(new Buffer(var13));
                  }

                  InvType.inventoryCache.put(var11, (long)var3);
                  var12 = var11;
               }

               var9[var10] = var12.size;
               return 1;
            } else if(var0 == 3305) {
               var3 = class82.intStack[--class82.intStackSize];
               class82.intStack[++class82.intStackSize - 1] = Client.boostedSkillLevels[var3];
               return 1;
            } else if(var0 == 3306) {
               var3 = class82.intStack[--class82.intStackSize];
               class82.intStack[++class82.intStackSize - 1] = Client.realSkillLevels[var3];
               return 1;
            } else if(var0 == 3307) {
               var3 = class82.intStack[--class82.intStackSize];
               class82.intStack[++class82.intStackSize - 1] = Client.skillExperiences[var3];
               return 1;
            } else if(var0 == 3308) {
               var3 = class28.plane;
               var4 = (class275.localPlayer.x >> 7) + class13.baseX;
               var10 = (class275.localPlayer.y >> 7) + ClanMember.baseY;
               class82.intStack[++class82.intStackSize - 1] = (var4 << 14) + var10 + (var3 << 28);
               return 1;
            } else if(var0 == 3309) {
               var3 = class82.intStack[--class82.intStackSize];
               class82.intStack[++class82.intStackSize - 1] = var3 >> 14 & 16383;
               return 1;
            } else if(var0 == 3310) {
               var3 = class82.intStack[--class82.intStackSize];
               class82.intStack[++class82.intStackSize - 1] = var3 >> 28;
               return 1;
            } else if(var0 == 3311) {
               var3 = class82.intStack[--class82.intStackSize];
               class82.intStack[++class82.intStackSize - 1] = var3 & 16383;
               return 1;
            } else if(var0 == 3312) {
               class82.intStack[++class82.intStackSize - 1] = Client.isMembers?1:0;
               return 1;
            } else if(var0 != 3313) {
               if(var0 == 3314) {
                  class82.intStackSize -= 2;
                  var3 = class82.intStack[class82.intStackSize] + 32768;
                  var4 = class82.intStack[class82.intStackSize + 1];
                  class82.intStack[++class82.intStackSize - 1] = class47.method663(var3, var4);
                  return 1;
               } else if(var0 == 3315) {
                  class82.intStackSize -= 2;
                  var3 = class82.intStack[class82.intStackSize] + 32768;
                  var4 = class82.intStack[class82.intStackSize + 1];
                  class82.intStack[++class82.intStackSize - 1] = class211.method3849(var3, var4);
                  return 1;
               } else if(var0 == 3316) {
                  if(Client.rights >= 2) {
                     class82.intStack[++class82.intStackSize - 1] = Client.rights;
                  } else {
                     class82.intStack[++class82.intStackSize - 1] = 0;
                  }

                  return 1;
               } else if(var0 == 3317) {
                  class82.intStack[++class82.intStackSize - 1] = Client.field910;
                  return 1;
               } else if(var0 == 3318) {
                  class82.intStack[++class82.intStackSize - 1] = Client.world;
                  return 1;
               } else if(var0 == 3321) {
                  class82.intStack[++class82.intStackSize - 1] = Client.energy;
                  return 1;
               } else if(var0 == 3322) {
                  class82.intStack[++class82.intStackSize - 1] = Client.weight;
                  return 1;
               } else if(var0 == 3323) {
                  if(Client.field979) {
                     class82.intStack[++class82.intStackSize - 1] = 1;
                  } else {
                     class82.intStack[++class82.intStackSize - 1] = 0;
                  }

                  return 1;
               } else if(var0 == 3324) {
                  class82.intStack[++class82.intStackSize - 1] = Client.flags;
                  return 1;
               } else if(var0 == 3325) {
                  class82.intStackSize -= 4;
                  var3 = class82.intStack[class82.intStackSize];
                  var4 = class82.intStack[class82.intStackSize + 1];
                  var10 = class82.intStack[class82.intStackSize + 2];
                  var6 = class82.intStack[class82.intStackSize + 3];
                  var3 += var4 << 14;
                  var3 += var10 << 28;
                  var3 += var6;
                  class82.intStack[++class82.intStackSize - 1] = var3;
                  return 1;
               } else {
                  return 2;
               }
            } else {
               class82.intStackSize -= 2;
               var3 = class82.intStack[class82.intStackSize] + 32768;
               var4 = class82.intStack[class82.intStackSize + 1];
               var5 = class82.intStack;
               var6 = ++class82.intStackSize - 1;
               var8 = (ItemContainer)ItemContainer.itemContainers.get((long)var3);
               if(var8 == null) {
                  var7 = -1;
               } else if(var4 >= 0 && var4 < var8.itemIds.length) {
                  var7 = var8.itemIds[var4];
               } else {
                  var7 = -1;
               }

               var5[var6] = var7;
               return 1;
            }
         }
      }
   }

   @ObfuscatedName("fb")
   @ObfuscatedSignature(
      signature = "(Lbw;I)V",
      garbageValue = "-840589843"
   )
   static final void method2414(Actor var0) {
      if(var0.field1191 == Client.gameCycle || var0.animation == -1 || var0.actionAnimationDisable != 0 || var0.field1144 + 1 > class90.getAnimation(var0.animation).frameLenghts[var0.actionFrame]) {
         int var1 = var0.field1191 - var0.field1178;
         int var2 = Client.gameCycle - var0.field1178;
         int var3 = var0.field1186 * 128 + var0.field1148 * 64;
         int var4 = var0.field1162 * 128 + var0.field1148 * 64;
         int var5 = var0.field1174 * 128 + var0.field1148 * 64;
         int var6 = var0.field1164 * 128 + var0.field1148 * 64;
         var0.x = (var2 * var5 + var3 * (var1 - var2)) / var1;
         var0.y = (var6 * var2 + var4 * (var1 - var2)) / var1;
      }

      var0.field1202 = 0;
      var0.orientation = var0.field1195;
      var0.angle = var0.orientation;
   }
}
