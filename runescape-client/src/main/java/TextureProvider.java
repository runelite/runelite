import java.io.File;
import java.io.IOException;
import java.util.Date;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dx")
@Implements("TextureProvider")
public class TextureProvider implements ITextureLoader {
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1855884401
   )
   @Export("width")
   int width;
   @ObfuscatedName("w")
   @Export("brightness")
   double brightness;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "[Lef;"
   )
   @Export("textures")
   Texture[] textures;
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lgv;"
   )
   @Export("deque")
   Deque deque;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 131408633
   )
   @Export("size")
   int size;
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "Lit;"
   )
   @Export("sprites")
   IndexDataBase sprites;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1015116961
   )
   @Export("maxSize")
   int maxSize;

   @ObfuscatedSignature(
      signature = "(Lit;Lit;IDI)V"
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

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-118"
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

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-1886925429"
   )
   @Export("getAverageTextureRGB")
   public int getAverageTextureRGB(int var1) {
      return this.textures[var1] != null?this.textures[var1].field1864:0;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(II)[I",
      garbageValue = "1528112396"
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

         boolean var3 = var2.method2502(this.brightness, this.width, this.sprites);
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

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(IB)Z",
      garbageValue = "4"
   )
   public boolean vmethod2919(int var1) {
      return this.width == 64;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "87692413"
   )
   public boolean vmethod2923(int var1) {
      return this.textures[var1].field1863;
   }

   @ObfuscatedName("e")
   @Export("brightness")
   public void brightness(double var1) {
      this.brightness = var1;
      this.reset();
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(IS)V",
      garbageValue = "32767"
   )
   public void method2398(int var1) {
      for(int var2 = 0; var2 < this.textures.length; ++var2) {
         Texture var3 = this.textures[var2];
         if(var3 != null && var3.field1870 != 0 && var3.loaded) {
            var3.method2504(var1);
            var3.loaded = false;
         }
      }

   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;ZB)Ldk;",
      garbageValue = "-99"
   )
   @Export("getPreferencesFile")
   public static FileOnDisk getPreferencesFile(String var0, String var1, boolean var2) {
      File var3 = new File(class294.field3885, "preferences" + var0 + ".dat");
      if(var3.exists()) {
         try {
            FileOnDisk var10 = new FileOnDisk(var3, "rw", 10000L);
            return var10;
         } catch (IOException var9) {
            ;
         }
      }

      String var4 = "";
      if(class141.field2111 == 33) {
         var4 = "_rc";
      } else if(class141.field2111 == 34) {
         var4 = "_wip";
      }

      File var5 = new File(class33.userHome, "jagex_" + var1 + "_preferences" + var0 + var4 + ".dat");
      FileOnDisk var6;
      if(!var2 && var5.exists()) {
         try {
            var6 = new FileOnDisk(var5, "rw", 10000L);
            return var6;
         } catch (IOException var8) {
            ;
         }
      }

      try {
         var6 = new FileOnDisk(var3, "rw", 10000L);
         return var6;
      } catch (IOException var7) {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(ILcc;ZB)I",
      garbageValue = "98"
   )
   static int method2404(int var0, Script var1, boolean var2) {
      String var3;
      int var4;
      if(var0 == 4100) {
         var3 = class84.scriptStringStack[--class84.scriptStringStackSize];
         var4 = class84.intStack[--class84.intStackSize];
         class84.scriptStringStack[++class84.scriptStringStackSize - 1] = var3 + var4;
         return 1;
      } else {
         String var19;
         if(var0 == 4101) {
            class84.scriptStringStackSize -= 2;
            var3 = class84.scriptStringStack[class84.scriptStringStackSize];
            var19 = class84.scriptStringStack[class84.scriptStringStackSize + 1];
            class84.scriptStringStack[++class84.scriptStringStackSize - 1] = var3 + var19;
            return 1;
         } else {
            int var18;
            if(var0 == 4102) {
               var3 = class84.scriptStringStack[--class84.scriptStringStackSize];
               var4 = class84.intStack[--class84.intStackSize];
               String[] var5 = class84.scriptStringStack;
               var18 = ++class84.scriptStringStackSize - 1;
               String var8;
               if(var4 < 0) {
                  var8 = Integer.toString(var4);
               } else {
                  var8 = FloorUnderlayDefinition.method4383(var4, 10, true);
               }

               var5[var18] = var3 + var8;
               return 1;
            } else if(var0 == 4103) {
               var3 = class84.scriptStringStack[--class84.scriptStringStackSize];
               class84.scriptStringStack[++class84.scriptStringStackSize - 1] = var3.toLowerCase();
               return 1;
            } else {
               int var10;
               if(var0 == 4104) {
                  var10 = class84.intStack[--class84.intStackSize];
                  long var11 = (11745L + (long)var10) * 86400000L;
                  class84.field1337.setTime(new Date(var11));
                  var18 = class84.field1337.get(5);
                  int var21 = class84.field1337.get(2);
                  int var14 = class84.field1337.get(1);
                  class84.scriptStringStack[++class84.scriptStringStackSize - 1] = var18 + "-" + class84.field1338[var21] + "-" + var14;
                  return 1;
               } else if(var0 == 4105) {
                  class84.scriptStringStackSize -= 2;
                  var3 = class84.scriptStringStack[class84.scriptStringStackSize];
                  var19 = class84.scriptStringStack[class84.scriptStringStackSize + 1];
                  if(class54.localPlayer.composition != null && class54.localPlayer.composition.isFemale) {
                     class84.scriptStringStack[++class84.scriptStringStackSize - 1] = var19;
                  } else {
                     class84.scriptStringStack[++class84.scriptStringStackSize - 1] = var3;
                  }

                  return 1;
               } else if(var0 == 4106) {
                  var10 = class84.intStack[--class84.intStackSize];
                  class84.scriptStringStack[++class84.scriptStringStackSize - 1] = Integer.toString(var10);
                  return 1;
               } else if(var0 == 4107) {
                  class84.scriptStringStackSize -= 2;
                  int[] var17 = class84.intStack;
                  var4 = ++class84.intStackSize - 1;
                  var18 = CacheFile.method2371(class84.scriptStringStack[class84.scriptStringStackSize], class84.scriptStringStack[class84.scriptStringStackSize + 1], Client.languageId);
                  byte var23;
                  if(var18 > 0) {
                     var23 = 1;
                  } else if(var18 < 0) {
                     var23 = -1;
                  } else {
                     var23 = 0;
                  }

                  var17[var4] = var23;
                  return 1;
               } else {
                  Font var7;
                  int var15;
                  byte[] var16;
                  if(var0 == 4108) {
                     var3 = class84.scriptStringStack[--class84.scriptStringStackSize];
                     class84.intStackSize -= 2;
                     var4 = class84.intStack[class84.intStackSize];
                     var15 = class84.intStack[class84.intStackSize + 1];
                     var16 = WidgetNode.field824.getConfigData(var15, 0);
                     var7 = new Font(var16);
                     class84.intStack[++class84.intStackSize - 1] = var7.method4774(var3, var4);
                     return 1;
                  } else if(var0 == 4109) {
                     var3 = class84.scriptStringStack[--class84.scriptStringStackSize];
                     class84.intStackSize -= 2;
                     var4 = class84.intStack[class84.intStackSize];
                     var15 = class84.intStack[class84.intStackSize + 1];
                     var16 = WidgetNode.field824.getConfigData(var15, 0);
                     var7 = new Font(var16);
                     class84.intStack[++class84.intStackSize - 1] = var7.method4773(var3, var4);
                     return 1;
                  } else if(var0 == 4110) {
                     class84.scriptStringStackSize -= 2;
                     var3 = class84.scriptStringStack[class84.scriptStringStackSize];
                     var19 = class84.scriptStringStack[class84.scriptStringStackSize + 1];
                     if(class84.intStack[--class84.intStackSize] == 1) {
                        class84.scriptStringStack[++class84.scriptStringStackSize - 1] = var3;
                     } else {
                        class84.scriptStringStack[++class84.scriptStringStackSize - 1] = var19;
                     }

                     return 1;
                  } else if(var0 == 4111) {
                     var3 = class84.scriptStringStack[--class84.scriptStringStackSize];
                     class84.scriptStringStack[++class84.scriptStringStackSize - 1] = FontTypeFace.appendTags(var3);
                     return 1;
                  } else if(var0 == 4112) {
                     var3 = class84.scriptStringStack[--class84.scriptStringStackSize];
                     var4 = class84.intStack[--class84.intStackSize];
                     class84.scriptStringStack[++class84.scriptStringStackSize - 1] = var3 + (char)var4;
                     return 1;
                  } else if(var0 == 4113) {
                     var10 = class84.intStack[--class84.intStackSize];
                     class84.intStack[++class84.intStackSize - 1] = ScriptState.method1072((char)var10)?1:0;
                     return 1;
                  } else if(var0 == 4114) {
                     var10 = class84.intStack[--class84.intStackSize];
                     class84.intStack[++class84.intStackSize - 1] = class97.method1831((char)var10)?1:0;
                     return 1;
                  } else if(var0 == 4115) {
                     var10 = class84.intStack[--class84.intStackSize];
                     class84.intStack[++class84.intStackSize - 1] = InvType.method4272((char)var10)?1:0;
                     return 1;
                  } else {
                     char var13;
                     if(var0 != 4116) {
                        if(var0 == 4117) {
                           var3 = class84.scriptStringStack[--class84.scriptStringStackSize];
                           if(var3 != null) {
                              class84.intStack[++class84.intStackSize - 1] = var3.length();
                           } else {
                              class84.intStack[++class84.intStackSize - 1] = 0;
                           }

                           return 1;
                        } else if(var0 == 4118) {
                           var3 = class84.scriptStringStack[--class84.scriptStringStackSize];
                           class84.intStackSize -= 2;
                           var4 = class84.intStack[class84.intStackSize];
                           var15 = class84.intStack[class84.intStackSize + 1];
                           class84.scriptStringStack[++class84.scriptStringStackSize - 1] = var3.substring(var4, var15);
                           return 1;
                        } else if(var0 == 4119) {
                           var3 = class84.scriptStringStack[--class84.scriptStringStackSize];
                           StringBuilder var20 = new StringBuilder(var3.length());
                           boolean var22 = false;

                           for(var18 = 0; var18 < var3.length(); ++var18) {
                              var13 = var3.charAt(var18);
                              if(var13 == 60) {
                                 var22 = true;
                              } else if(var13 == 62) {
                                 var22 = false;
                              } else if(!var22) {
                                 var20.append(var13);
                              }
                           }

                           class84.scriptStringStack[++class84.scriptStringStackSize - 1] = var20.toString();
                           return 1;
                        } else if(var0 == 4120) {
                           var3 = class84.scriptStringStack[--class84.scriptStringStackSize];
                           var4 = class84.intStack[--class84.intStackSize];
                           class84.intStack[++class84.intStackSize - 1] = var3.indexOf(var4);
                           return 1;
                        } else if(var0 == 4121) {
                           class84.scriptStringStackSize -= 2;
                           var3 = class84.scriptStringStack[class84.scriptStringStackSize];
                           var19 = class84.scriptStringStack[class84.scriptStringStackSize + 1];
                           var15 = class84.intStack[--class84.intStackSize];
                           class84.intStack[++class84.intStackSize - 1] = var3.indexOf(var19, var15);
                           return 1;
                        } else {
                           return 2;
                        }
                     } else {
                        var10 = class84.intStack[--class84.intStackSize];
                        int[] var9 = class84.intStack;
                        var15 = ++class84.intStackSize - 1;
                        var13 = (char)var10;
                        boolean var6 = var13 >= 48 && var13 <= 57;
                        var9[var15] = var6?1:0;
                        return 1;
                     }
                  }
               }
            }
         }
      }
   }
}
