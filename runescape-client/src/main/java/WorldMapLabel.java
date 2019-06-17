import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InvalidClassException;
import java.io.ObjectInputStream;
import java.io.OptionalDataException;
import java.io.StreamCorruptedException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.Reflection;

@ObfuscatedName("aj")
@Implements("WorldMapLabel")
public class WorldMapLabel {
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1536028937
   )
   @Export("__aj_e")
   public static int __aj_e;
   @ObfuscatedName("m")
   @Export("text")
   String text;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -471061617
   )
   @Export("width")
   int width;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -85027761
   )
   @Export("height")
   int height;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Ls;"
   )
   @Export("size")
   WorldMapLabelSize size;

   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;IILs;)V"
   )
   WorldMapLabel(String var1, int var2, int var3, WorldMapLabelSize var4) {
      this.text = var1;
      this.width = var2;
      this.height = var3;
      this.size = var4;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Lhx;I)V",
      garbageValue = "-1747135919"
   )
   public static void method443(PacketBuffer var0) {
      ReflectionCheck var1 = (ReflectionCheck)class322.reflectionChecks.last();
      if(var1 != null) {
         int var2 = var0.index;
         var0.writeInt(var1.id);

         for(int var3 = 0; var3 < var1.size; ++var3) {
            if(var1.creationErrors[var3] != 0) {
               var0.writeByte(var1.creationErrors[var3]);
            } else {
               try {
                  int var4 = var1.operations[var3];
                  Field var5;
                  int var6;
                  if(var4 == 0) {
                     var5 = var1.fields[var3];
                     var6 = Reflection.getInt(var5, (Object)null);
                     var0.writeByte(0);
                     var0.writeInt(var6);
                  } else if(var4 == 1) {
                     var5 = var1.fields[var3];
                     Reflection.setInt(var5, (Object)null, var1.intReplaceValues[var3]);
                     var0.writeByte(0);
                  } else if(var4 == 2) {
                     var5 = var1.fields[var3];
                     var6 = var5.getModifiers();
                     var0.writeByte(0);
                     var0.writeInt(var6);
                  }

                  Method var7;
                  if(var4 != 3) {
                     if(var4 == 4) {
                        var7 = var1.methods[var3];
                        var6 = var7.getModifiers();
                        var0.writeByte(0);
                        var0.writeInt(var6);
                     }
                  } else {
                     var7 = var1.methods[var3];
                     byte[][] var8 = var1.arguments[var3];
                     Object[] var9 = new Object[var8.length];

                     for(int var10 = 0; var10 < var8.length; ++var10) {
                        ObjectInputStream var11 = new ObjectInputStream(new ByteArrayInputStream(var8[var10]));
                        var9[var10] = var11.readObject();
                     }

                     Object var24 = Reflection.invoke(var7, (Object)null, var9);
                     if(var24 == null) {
                        var0.writeByte(0);
                     } else if(var24 instanceof Number) {
                        var0.writeByte(1);
                        var0.writeLong(((Number)var24).longValue());
                     } else if(var24 instanceof String) {
                        var0.writeByte(2);
                        var0.writeStringCp1252NullTerminated((String)var24);
                     } else {
                        var0.writeByte(4);
                     }
                  }
               } catch (ClassNotFoundException var12) {
                  var0.writeByte(-10);
               } catch (InvalidClassException var13) {
                  var0.writeByte(-11);
               } catch (StreamCorruptedException var14) {
                  var0.writeByte(-12);
               } catch (OptionalDataException var15) {
                  var0.writeByte(-13);
               } catch (IllegalAccessException var16) {
                  var0.writeByte(-14);
               } catch (IllegalArgumentException var17) {
                  var0.writeByte(-15);
               } catch (InvocationTargetException var18) {
                  var0.writeByte(-16);
               } catch (SecurityException var19) {
                  var0.writeByte(-17);
               } catch (IOException var20) {
                  var0.writeByte(-18);
               } catch (NullPointerException var21) {
                  var0.writeByte(-19);
               } catch (Exception var22) {
                  var0.writeByte(-20);
               } catch (Throwable var23) {
                  var0.writeByte(-21);
               }
            }
         }

         var0.__aa_312(var2);
         var1.remove();
      }

   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "823291412"
   )
   static int method442(int var0, int var1) {
      ItemContainer var2 = (ItemContainer)ItemContainer.itemContainers.get((long)var0);
      return var2 == null?0:(var1 >= 0 && var1 < var2.quantities.length?var2.quantities[var1]:0);
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)[Llq;",
      garbageValue = "-1374541046"
   )
   public static IndexedSprite[] method444() {
      IndexedSprite[] var0 = new IndexedSprite[class328.indexedSpriteCount];

      for(int var1 = 0; var1 < class328.indexedSpriteCount; ++var1) {
         IndexedSprite var2 = var0[var1] = new IndexedSprite();
         var2.width = class328.indexedSpriteWidth;
         var2.height = class328.indexedSpriteHeight;
         var2.xOffset = class328.indexedSpriteOffsetXs[var1];
         var2.yOffset = class328.indexedSpriteOffsetYs[var1];
         var2.subWidth = VarbitDefinition.indexedSpriteWidths[var1];
         var2.subHeight = SecureRandomCallable.indexedSpriteHeights[var1];
         var2.palette = class328.indexedSpritePalette;
         var2.pixels = class328.spritePixels[var1];
      }

      class328.indexedSpriteOffsetXs = null;
      class328.indexedSpriteOffsetYs = null;
      VarbitDefinition.indexedSpriteWidths = null;
      SecureRandomCallable.indexedSpriteHeights = null;
      class328.indexedSpritePalette = null;
      class328.spritePixels = (byte[][])null;
      return var0;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Lbt;Lbt;IZI)I",
      garbageValue = "1459100828"
   )
   @Export("compareWorlds")
   static int compareWorlds(World var0, World var1, int var2, boolean var3) {
      if(var2 == 1) {
         int var4 = var0.population;
         int var5 = var1.population;
         if(!var3) {
            if(var4 == -1) {
               var4 = 2001;
            }

            if(var5 == -1) {
               var5 = 2001;
            }
         }

         return var4 - var5;
      } else {
         return var2 == 2?var0.location - var1.location:(var2 == 3?(var0.activity.equals("-")?(var1.activity.equals("-")?0:(var3?-1:1)):(var1.activity.equals("-")?(var3?1:-1):var0.activity.compareTo(var1.activity))):(var2 == 4?(var0.__a_147()?(var1.__a_147()?0:1):(var1.__a_147()?-1:0)):(var2 == 5?(var0.__x_145()?(var1.__x_145()?0:1):(var1.__x_145()?-1:0)):(var2 == 6?(var0.__d_146()?(var1.__d_146()?0:1):(var1.__d_146()?-1:0)):(var2 == 7?(var0.__e_144()?(var1.__e_144()?0:1):(var1.__e_144()?-1:0)):var0.id - var1.id)))));
      }
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "60"
   )
   public static void method440() {
      NPCDefinition.NpcDefinition_cached.clear();
      NPCDefinition.NpcDefinition_cachedModels.clear();
   }

   @ObfuscatedName("gx")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "-1610474394"
   )
   @Export("worldToScreen")
   static final void worldToScreen(int var0, int var1, int var2) {
      if(var0 >= 128 && var1 >= 128 && var0 <= 13056 && var1 <= 13056) {
         int var3 = class32.getTileHeight(var0, var1, SoundSystem.plane) - var2;
         var0 -= WorldMapSection1.cameraX;
         var3 -= GrandExchangeEvents.cameraY;
         var1 -= class11.cameraZ;
         int var4 = Rasterizer3D.Rasterizer3D_sine[WorldMapIcon1.cameraPitch];
         int var5 = Rasterizer3D.Rasterizer3D_cosine[WorldMapIcon1.cameraPitch];
         int var6 = Rasterizer3D.Rasterizer3D_sine[MusicPatchNode.cameraYaw];
         int var7 = Rasterizer3D.Rasterizer3D_cosine[MusicPatchNode.cameraYaw];
         int var8 = var0 * var7 + var6 * var1 >> 16;
         var1 = var7 * var1 - var0 * var6 >> 16;
         var0 = var8;
         var8 = var3 * var5 - var4 * var1 >> 16;
         var1 = var5 * var1 + var3 * var4 >> 16;
         if(var1 >= 50) {
            Client.viewportTempX = var0 * Client.viewportZoom / var1 + Client.viewportWidth / 2;
            Client.viewportTempY = var8 * Client.viewportZoom / var1 + Client.viewportHeight / 2;
         } else {
            Client.viewportTempX = -1;
            Client.viewportTempY = -1;
         }
      } else {
         Client.viewportTempX = -1;
         Client.viewportTempY = -1;
      }

   }
}
