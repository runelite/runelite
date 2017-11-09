import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InvalidClassException;
import java.io.ObjectInputStream;
import java.io.OptionalDataException;
import java.io.StreamCorruptedException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.Reflection;

@ObfuscatedName("cd")
@Implements("World")
public class World {
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 625587547
   )
   @Export("worldCount")
   static int worldCount;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1407069757
   )
   static int field1216;
   @ObfuscatedName("l")
   static int[] field1219;
   @ObfuscatedName("b")
   static int[] field1213;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 946021185
   )
   @Export("id")
   int id;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 138916581
   )
   @Export("mask")
   int mask;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 713437225
   )
   @Export("playerCount")
   int playerCount;
   @ObfuscatedName("w")
   @Export("address")
   String address;
   @ObfuscatedName("k")
   @Export("activity")
   String activity;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 500868101
   )
   @Export("location")
   int location;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1515304451
   )
   @Export("index")
   int index;

   static {
      worldCount = 0;
      field1216 = 0;
      field1219 = new int[]{1, 1, 1, 1};
      field1213 = new int[]{0, 1, 2, 3};
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1970456049"
   )
   boolean method1640() {
      return (1 & this.mask) != 0;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "983224086"
   )
   boolean method1636() {
      return (2 & this.mask) != 0;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1032049239"
   )
   boolean method1637() {
      return (4 & this.mask) != 0;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "-118"
   )
   boolean method1638() {
      return (8 & this.mask) != 0;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "120"
   )
   boolean method1656() {
      return (536870912 & this.mask) != 0;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-2109939672"
   )
   boolean method1639() {
      return (33554432 & this.mask) != 0;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Lgi;I)V",
      garbageValue = "938625238"
   )
   @Export("encodeClassVerifier")
   public static void encodeClassVerifier(PacketBuffer var0) {
      ClassInfo var1 = (ClassInfo)class289.field3811.method3741();
      if(var1 != null) {
         int var2 = var0.offset;
         var0.putInt(var1.field3798);

         for(int var3 = 0; var3 < var1.count; ++var3) {
            if(var1.errorIdentifiers[var3] != 0) {
               var0.putByte(var1.errorIdentifiers[var3]);
            } else {
               try {
                  int var4 = var1.type[var3];
                  Field var5;
                  int var6;
                  if(var4 == 0) {
                     var5 = var1.fields[var3];
                     var6 = Reflection.getInt(var5, (Object)null);
                     var0.putByte(0);
                     var0.putInt(var6);
                  } else if(var4 == 1) {
                     var5 = var1.fields[var3];
                     Reflection.setInt(var5, (Object)null, var1.field3803[var3]);
                     var0.putByte(0);
                  } else if(var4 == 2) {
                     var5 = var1.fields[var3];
                     var6 = var5.getModifiers();
                     var0.putByte(0);
                     var0.putInt(var6);
                  }

                  Method var25;
                  if(var4 != 3) {
                     if(var4 == 4) {
                        var25 = var1.methods[var3];
                        var6 = var25.getModifiers();
                        var0.putByte(0);
                        var0.putInt(var6);
                     }
                  } else {
                     var25 = var1.methods[var3];
                     byte[][] var10 = var1.args[var3];
                     Object[] var7 = new Object[var10.length];

                     for(int var8 = 0; var8 < var10.length; ++var8) {
                        ObjectInputStream var9 = new ObjectInputStream(new ByteArrayInputStream(var10[var8]));
                        var7[var8] = var9.readObject();
                     }

                     Object var11 = Reflection.invoke(var25, (Object)null, var7);
                     if(var11 == null) {
                        var0.putByte(0);
                     } else if(var11 instanceof Number) {
                        var0.putByte(1);
                        var0.putLong(((Number)var11).longValue());
                     } else if(var11 instanceof String) {
                        var0.putByte(2);
                        var0.putString((String)var11);
                     } else {
                        var0.putByte(4);
                     }
                  }
               } catch (ClassNotFoundException var13) {
                  var0.putByte(-10);
               } catch (InvalidClassException var14) {
                  var0.putByte(-11);
               } catch (StreamCorruptedException var15) {
                  var0.putByte(-12);
               } catch (OptionalDataException var16) {
                  var0.putByte(-13);
               } catch (IllegalAccessException var17) {
                  var0.putByte(-14);
               } catch (IllegalArgumentException var18) {
                  var0.putByte(-15);
               } catch (InvocationTargetException var19) {
                  var0.putByte(-16);
               } catch (SecurityException var20) {
                  var0.putByte(-17);
               } catch (IOException var21) {
                  var0.putByte(-18);
               } catch (NullPointerException var22) {
                  var0.putByte(-19);
               } catch (Exception var23) {
                  var0.putByte(-20);
               } catch (Throwable var24) {
                  var0.putByte(-21);
               }
            }
         }

         var0.putCrc(var2);
         var1.unlink();
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ILjava/lang/String;I)Z",
      garbageValue = "-1049625122"
   )
   static boolean method1670(String var0, int var1, String var2) {
      if(var1 == 0) {
         try {
            if(!class56.field642.startsWith("win")) {
               throw new Exception();
            } else if(!var0.startsWith("http://") && !var0.startsWith("https://")) {
               throw new Exception();
            } else {
               String var10 = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789?&=,.%+-_#:/*";

               for(int var4 = 0; var4 < var0.length(); ++var4) {
                  if(var10.indexOf(var0.charAt(var4)) == -1) {
                     throw new Exception();
                  }
               }

               Runtime.getRuntime().exec("cmd /c start \"j\" \"" + var0 + "\"");
               return true;
            }
         } catch (Throwable var5) {
            return false;
         }
      } else if(var1 == 1) {
         try {
            Object var3 = class52.method845(class56.field653, var2, new Object[]{(new URL(class56.field653.getCodeBase(), var0)).toString()});
            return var3 != null;
         } catch (Throwable var6) {
            return false;
         }
      } else if(var1 == 2) {
         try {
            class56.field653.getAppletContext().showDocument(new URL(class56.field653.getCodeBase(), var0), "_blank");
            return true;
         } catch (Exception var7) {
            return false;
         }
      } else if(var1 == 3) {
         try {
            class52.method847(class56.field653, "loggedout");
         } catch (Throwable var9) {
            ;
         }

         try {
            class56.field653.getAppletContext().showDocument(new URL(class56.field653.getCodeBase(), var0), "_top");
            return true;
         } catch (Exception var8) {
            return false;
         }
      } else {
         throw new IllegalArgumentException();
      }
   }

   @ObfuscatedName("fd")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "168480118"
   )
   static final void method1669() {
      Overlay.overlays.reset();
      class234.method4243();
      class214.method4044();
      ObjectComposition.objects.reset();
      ObjectComposition.field3490.reset();
      ObjectComposition.cachedModels.reset();
      ObjectComposition.field3489.reset();
      NPCComposition.npcs.reset();
      NPCComposition.npcModelCache.reset();
      Client.method1500();
      Sequence.sequences.reset();
      Sequence.skeletons.reset();
      Spotanim.spotanims.reset();
      Spotanim.field3383.reset();
      CombatInfoListHolder.method1768();
      VarPlayerType.varplayers.reset();
      class261.field3482.reset();
      class261.field3465.reset();
      class261.field3485.reset();
      class25.method202();
      class181.method3515();
      class258.field3440.reset();
      Area.skeletonsIndex.reset();
      PlayerComposition.field2695.reset();
      Widget.field2720.reset();
      Widget.field2797.reset();
      Widget.field2722.reset();
      Widget.field2723.reset();
      ((TextureProvider)Graphics3D.textureLoader).reset();
      Script.field1445.reset();
      Varcs.indexInterfaces.reset();
      class31.indexSoundEffects.reset();
      class149.field2115.reset();
      Tile.field1838.reset();
      class56.indexMaps.reset();
      class21.indexTrack1.reset();
      class48.indexModels.reset();
      class96.indexSprites.reset();
      class12.indexTextures.reset();
      AbstractSoundSystem.field1563.reset();
      class236.indexTrack2.reset();
      class43.indexScripts.reset();
   }
}
