import net.runelite.mapping.*;
import net.runelite.rs.Reflection;

import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@ObfuscatedName("hy")
@Implements("SpritePixels2")
public class SpritePixels2 extends CacheableNode {
   @ObfuscatedName("bs")
   @ObfuscatedSignature(
      signature = "[Lkg;"
   )
   @Export("slFlagSprites")
   static IndexedSprite[] slFlagSprites;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1363095853
   )
   public final int field2715;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 1699463023
   )
   public final int field2716;
   @ObfuscatedName("e")
   public final int[] field2714;
   @ObfuscatedName("k")
   public final int[] field2717;

   SpritePixels2(int var1, int var2, int[] var3, int[] var4, int var5) {
      this.field2715 = var1;
      this.field2716 = var2;
      this.field2714 = var3;
      this.field2717 = var4;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "1260663886"
   )
   public boolean method4073(int var1, int var2) {
      if(var2 >= 0 && var2 < this.field2717.length) {
         int var3 = this.field2717[var2];
         if(var1 >= var3 && var1 <= var3 + this.field2714[var2]) {
            return true;
         }
      }

      return false;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;Lkz;S)Ljava/lang/String;",
      garbageValue = "671"
   )
   @Export("cleanUsername")
   public static String cleanUsername(CharSequence var0, JagexLoginType var1) {
      if(var0 == null) {
         return null;
      } else {
         int var2 = 0;

         int var3;
         boolean var4;
         char var5;
         for(var3 = var0.length(); var2 < var3; ++var2) {
            var5 = var0.charAt(var2);
            var4 = var5 == 160 || var5 == ' ' || var5 == '_' || var5 == '-';
            if(!var4) {
               break;
            }
         }

         while(var3 > var2) {
            var5 = var0.charAt(var3 - 1);
            var4 = var5 == 160 || var5 == ' ' || var5 == '_' || var5 == '-';
            if(!var4) {
               break;
            }

            --var3;
         }

         int var14 = var3 - var2;
         if(var14 >= 1) {
            byte var6;
            if(var1 == null) {
               var6 = 12;
            } else {
               switch(var1.field3928) {
               case 2:
                  var6 = 20;
                  break;
               default:
                  var6 = 12;
               }
            }

            if(var14 <= var6) {
               StringBuilder var12 = new StringBuilder(var14);

               for(int var15 = var2; var15 < var3; ++var15) {
                  char var7 = var0.charAt(var15);
                  boolean var8;
                  if(Character.isISOControl(var7)) {
                     var8 = false;
                  } else if(UrlRequest.method2926(var7)) {
                     var8 = true;
                  } else {
                     char[] var13 = class278.field3732;
                     int var10 = 0;

                     label120:
                     while(true) {
                        char var11;
                        if(var10 >= var13.length) {
                           var13 = class278.field3733;

                           for(var10 = 0; var10 < var13.length; ++var10) {
                              var11 = var13[var10];
                              if(var11 == var7) {
                                 var8 = true;
                                 break label120;
                              }
                           }

                           var8 = false;
                           break;
                        }

                        var11 = var13[var10];
                        if(var7 == var11) {
                           var8 = true;
                           break;
                        }

                        ++var10;
                     }
                  }

                  if(var8) {
                     char var9;
                     switch(var7) {
                     case ' ':
                     case '-':
                     case '_':
                     case ' ':
                        var9 = '_';
                        break;
                     case '#':
                     case '[':
                     case ']':
                        var9 = var7;
                        break;
                     case 'À':
                     case 'Á':
                     case 'Â':
                     case 'Ã':
                     case 'Ä':
                     case 'à':
                     case 'á':
                     case 'â':
                     case 'ã':
                     case 'ä':
                        var9 = 'a';
                        break;
                     case 'Ç':
                     case 'ç':
                        var9 = 'c';
                        break;
                     case 'È':
                     case 'É':
                     case 'Ê':
                     case 'Ë':
                     case 'è':
                     case 'é':
                     case 'ê':
                     case 'ë':
                        var9 = 'e';
                        break;
                     case 'Í':
                     case 'Î':
                     case 'Ï':
                     case 'í':
                     case 'î':
                     case 'ï':
                        var9 = 'i';
                        break;
                     case 'Ñ':
                     case 'ñ':
                        var9 = 'n';
                        break;
                     case 'Ò':
                     case 'Ó':
                     case 'Ô':
                     case 'Õ':
                     case 'Ö':
                     case 'ò':
                     case 'ó':
                     case 'ô':
                     case 'õ':
                     case 'ö':
                        var9 = 'o';
                        break;
                     case 'Ù':
                     case 'Ú':
                     case 'Û':
                     case 'Ü':
                     case 'ù':
                     case 'ú':
                     case 'û':
                     case 'ü':
                        var9 = 'u';
                        break;
                     case 'ß':
                        var9 = 'b';
                        break;
                     case 'ÿ':
                     case 'Ÿ':
                        var9 = 'y';
                        break;
                     default:
                        var9 = Character.toLowerCase(var7);
                     }

                     if(var9 != 0) {
                        var12.append(var9);
                     }
                  }
               }

               if(var12.length() == 0) {
                  return null;
               }

               return var12.toString();
            }
         }

         return null;
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Lgy;B)V",
      garbageValue = "-36"
   )
   @Export("encodeClassVerifier")
   public static void encodeClassVerifier(PacketBuffer var0) {
      ClassInfo var1 = (ClassInfo)class293.classInfos.last();
      if(var1 != null) {
         int var2 = var0.offset;
         var0.putInt(var1.field3819);

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
                     Reflection.setInt(var5, (Object)null, var1.field3820[var3]);
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
}
