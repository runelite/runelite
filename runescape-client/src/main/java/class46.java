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
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.Reflection;

@ObfuscatedName("ap")
public class class46 {
   @ObfuscatedName("mi")
   @ObfuscatedSignature(
      signature = "Lfw;"
   )
   static class157 field587;
   @ObfuscatedName("b")
   static int[] field590;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "[Ljp;"
   )
   static IndexedSprite[] field589;
   @ObfuscatedName("n")
   byte[][][] field588;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 71995573
   )
   int field593;

   class46(int var1) {
      this.field593 = var1;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-27"
   )
   void method689() {
      byte[] var1 = new byte[this.field593 * this.field593];
      int var2 = 0;

      int var3;
      int var4;
      for(var3 = 0; var3 < this.field593; ++var3) {
         for(var4 = 0; var4 < this.field593; ++var4) {
            if(var4 <= var3) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field588[0][0] = var1;
      var1 = new byte[this.field593 * this.field593];
      var2 = 0;

      for(var3 = this.field593 - 1; var3 >= 0; --var3) {
         for(var4 = 0; var4 < this.field593; ++var4) {
            if(var4 <= var3) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field588[0][1] = var1;
      var1 = new byte[this.field593 * this.field593];
      var2 = 0;

      for(var3 = 0; var3 < this.field593; ++var3) {
         for(var4 = 0; var4 < this.field593; ++var4) {
            if(var4 >= var3) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field588[0][2] = var1;
      var1 = new byte[this.field593 * this.field593];
      var2 = 0;

      for(var3 = this.field593 - 1; var3 >= 0; --var3) {
         for(var4 = 0; var4 < this.field593; ++var4) {
            if(var4 >= var3) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field588[0][3] = var1;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(IIB)I",
      garbageValue = "0"
   )
   int method696(int var1, int var2) {
      if(var2 == 9) {
         var1 = var1 + 1 & 3;
      }

      if(var2 == 10) {
         var1 = var1 + 3 & 3;
      }

      if(var2 == 11) {
         var1 = var1 + 3 & 3;
      }

      return var1;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1608043537"
   )
   void method663() {
      byte[] var1 = new byte[this.field593 * this.field593];
      int var2 = 0;

      int var3;
      int var4;
      for(var3 = this.field593 - 1; var3 >= 0; --var3) {
         for(var4 = 0; var4 < this.field593; ++var4) {
            if(var4 <= var3 >> 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field588[1][0] = var1;
      var1 = new byte[this.field593 * this.field593];
      var2 = 0;

      for(var3 = 0; var3 < this.field593; ++var3) {
         for(var4 = 0; var4 < this.field593; ++var4) {
            if(var2 >= 0 && var2 < var1.length) {
               if(var4 >= var3 << 1) {
                  var1[var2] = -1;
               }

               ++var2;
            } else {
               ++var2;
            }
         }
      }

      this.field588[1][1] = var1;
      var1 = new byte[this.field593 * this.field593];
      var2 = 0;

      for(var3 = 0; var3 < this.field593; ++var3) {
         for(var4 = this.field593 - 1; var4 >= 0; --var4) {
            if(var4 <= var3 >> 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field588[1][2] = var1;
      var1 = new byte[this.field593 * this.field593];
      var2 = 0;

      for(var3 = this.field593 - 1; var3 >= 0; --var3) {
         for(var4 = this.field593 - 1; var4 >= 0; --var4) {
            if(var4 >= var3 << 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field588[1][3] = var1;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-831140779"
   )
   int method660(int var1) {
      return var1 != 9 && var1 != 10?(var1 == 11?8:var1):1;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1156551945"
   )
   void method678() {
      byte[] var1 = new byte[this.field593 * this.field593];
      int var2 = 0;

      int var3;
      int var4;
      for(var3 = this.field593 - 1; var3 >= 0; --var3) {
         for(var4 = this.field593 - 1; var4 >= 0; --var4) {
            if(var4 <= var3 >> 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field588[2][0] = var1;
      var1 = new byte[this.field593 * this.field593];
      var2 = 0;

      for(var3 = this.field593 - 1; var3 >= 0; --var3) {
         for(var4 = 0; var4 < this.field593; ++var4) {
            if(var4 >= var3 << 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field588[2][1] = var1;
      var1 = new byte[this.field593 * this.field593];
      var2 = 0;

      for(var3 = 0; var3 < this.field593; ++var3) {
         for(var4 = 0; var4 < this.field593; ++var4) {
            if(var4 <= var3 >> 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field588[2][2] = var1;
      var1 = new byte[this.field593 * this.field593];
      var2 = 0;

      for(var3 = 0; var3 < this.field593; ++var3) {
         for(var4 = this.field593 - 1; var4 >= 0; --var4) {
            if(var4 >= var3 << 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field588[2][3] = var1;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "1"
   )
   void method665() {
      byte[] var1 = new byte[this.field593 * this.field593];
      int var2 = 0;

      int var3;
      int var4;
      for(var3 = this.field593 - 1; var3 >= 0; --var3) {
         for(var4 = 0; var4 < this.field593; ++var4) {
            if(var4 >= var3 >> 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field588[3][0] = var1;
      var1 = new byte[this.field593 * this.field593];
      var2 = 0;

      for(var3 = 0; var3 < this.field593; ++var3) {
         for(var4 = 0; var4 < this.field593; ++var4) {
            if(var4 <= var3 << 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field588[3][1] = var1;
      var1 = new byte[this.field593 * this.field593];
      var2 = 0;

      for(var3 = 0; var3 < this.field593; ++var3) {
         for(var4 = this.field593 - 1; var4 >= 0; --var4) {
            if(var4 >= var3 >> 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field588[3][2] = var1;
      var1 = new byte[this.field593 * this.field593];
      var2 = 0;

      for(var3 = this.field593 - 1; var3 >= 0; --var3) {
         for(var4 = this.field593 - 1; var4 >= 0; --var4) {
            if(var4 <= var3 << 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field588[3][3] = var1;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "256"
   )
   void method666() {
      byte[] var1 = new byte[this.field593 * this.field593];
      int var2 = 0;

      int var3;
      int var4;
      for(var3 = this.field593 - 1; var3 >= 0; --var3) {
         for(var4 = this.field593 - 1; var4 >= 0; --var4) {
            if(var4 >= var3 >> 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field588[4][0] = var1;
      var1 = new byte[this.field593 * this.field593];
      var2 = 0;

      for(var3 = this.field593 - 1; var3 >= 0; --var3) {
         for(var4 = 0; var4 < this.field593; ++var4) {
            if(var4 <= var3 << 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field588[4][1] = var1;
      var1 = new byte[this.field593 * this.field593];
      var2 = 0;

      for(var3 = 0; var3 < this.field593; ++var3) {
         for(var4 = 0; var4 < this.field593; ++var4) {
            if(var4 >= var3 >> 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field588[4][2] = var1;
      var1 = new byte[this.field593 * this.field593];
      var2 = 0;

      for(var3 = 0; var3 < this.field593; ++var3) {
         for(var4 = this.field593 - 1; var4 >= 0; --var4) {
            if(var4 <= var3 << 1) {
               var1[var2] = -1;
            }

            ++var2;
         }
      }

      this.field588[4][3] = var1;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2027971000"
   )
   void method667() {
      byte[] var1 = new byte[this.field593 * this.field593];
      boolean var2 = false;
      var1 = new byte[this.field593 * this.field593];
      int var5 = 0;

      int var3;
      int var4;
      for(var3 = 0; var3 < this.field593; ++var3) {
         for(var4 = 0; var4 < this.field593; ++var4) {
            if(var4 <= this.field593 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field588[5][0] = var1;
      var1 = new byte[this.field593 * this.field593];
      var5 = 0;

      for(var3 = 0; var3 < this.field593; ++var3) {
         for(var4 = 0; var4 < this.field593; ++var4) {
            if(var3 <= this.field593 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field588[5][1] = var1;
      var1 = new byte[this.field593 * this.field593];
      var5 = 0;

      for(var3 = 0; var3 < this.field593; ++var3) {
         for(var4 = 0; var4 < this.field593; ++var4) {
            if(var4 >= this.field593 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field588[5][2] = var1;
      var1 = new byte[this.field593 * this.field593];
      var5 = 0;

      for(var3 = 0; var3 < this.field593; ++var3) {
         for(var4 = 0; var4 < this.field593; ++var4) {
            if(var3 >= this.field593 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field588[5][3] = var1;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1158532279"
   )
   void method668() {
      byte[] var1 = new byte[this.field593 * this.field593];
      boolean var2 = false;
      var1 = new byte[this.field593 * this.field593];
      int var5 = 0;

      int var3;
      int var4;
      for(var3 = 0; var3 < this.field593; ++var3) {
         for(var4 = 0; var4 < this.field593; ++var4) {
            if(var4 <= var3 - this.field593 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field588[6][0] = var1;
      var1 = new byte[this.field593 * this.field593];
      var5 = 0;

      for(var3 = this.field593 - 1; var3 >= 0; --var3) {
         for(var4 = 0; var4 < this.field593; ++var4) {
            if(var4 <= var3 - this.field593 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field588[6][1] = var1;
      var1 = new byte[this.field593 * this.field593];
      var5 = 0;

      for(var3 = this.field593 - 1; var3 >= 0; --var3) {
         for(var4 = this.field593 - 1; var4 >= 0; --var4) {
            if(var4 <= var3 - this.field593 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field588[6][2] = var1;
      var1 = new byte[this.field593 * this.field593];
      var5 = 0;

      for(var3 = 0; var3 < this.field593; ++var3) {
         for(var4 = this.field593 - 1; var4 >= 0; --var4) {
            if(var4 <= var3 - this.field593 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field588[6][3] = var1;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IIIIIIIIB)V",
      garbageValue = "45"
   )
   void method658(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      if(var7 != 0 && this.field593 != 0 && this.field588 != null) {
         var8 = this.method696(var8, var7);
         var7 = this.method660(var7);
         Rasterizer2D.method4979(var1, var2, var5, var6, var3, var4, this.field588[var7 - 1][var8], this.field593);
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "107"
   )
   void method669() {
      byte[] var1 = new byte[this.field593 * this.field593];
      boolean var2 = false;
      var1 = new byte[this.field593 * this.field593];
      int var5 = 0;

      int var3;
      int var4;
      for(var3 = 0; var3 < this.field593; ++var3) {
         for(var4 = 0; var4 < this.field593; ++var4) {
            if(var4 >= var3 - this.field593 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field588[7][0] = var1;
      var1 = new byte[this.field593 * this.field593];
      var5 = 0;

      for(var3 = this.field593 - 1; var3 >= 0; --var3) {
         for(var4 = 0; var4 < this.field593; ++var4) {
            if(var4 >= var3 - this.field593 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field588[7][1] = var1;
      var1 = new byte[this.field593 * this.field593];
      var5 = 0;

      for(var3 = this.field593 - 1; var3 >= 0; --var3) {
         for(var4 = this.field593 - 1; var4 >= 0; --var4) {
            if(var4 >= var3 - this.field593 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field588[7][2] = var1;
      var1 = new byte[this.field593 * this.field593];
      var5 = 0;

      for(var3 = 0; var3 < this.field593; ++var3) {
         for(var4 = this.field593 - 1; var4 >= 0; --var4) {
            if(var4 >= var3 - this.field593 / 2) {
               var1[var5] = -1;
            }

            ++var5;
         }
      }

      this.field588[7][3] = var1;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1552024017"
   )
   void method661() {
      if(this.field588 == null) {
         this.field588 = new byte[8][4][];
         this.method689();
         this.method663();
         this.method678();
         this.method665();
         this.method666();
         this.method667();
         this.method668();
         this.method669();
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;I)I",
      garbageValue = "1175750056"
   )
   public static int method697(CharSequence var0) {
      int var1 = var0.length();
      int var2 = 0;

      for(int var3 = 0; var3 < var1; ++var3) {
         char var4 = var0.charAt(var3);
         if(var4 <= 127) {
            ++var2;
         } else if(var4 <= 2047) {
            var2 += 2;
         } else {
            var2 += 3;
         }
      }

      return var2;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Lfb;B)V",
      garbageValue = "-113"
   )
   @Export("encodeClassVerifier")
   public static void encodeClassVerifier(PacketBuffer var0) {
      ClassInfo var1 = (ClassInfo)class281.field3737.method3567();
      if(var1 != null) {
         int var2 = var0.offset;
         var0.putInt(var1.field3730);

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
                     Reflection.setInt(var5, (Object)null, var1.field3731[var3]);
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

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Lfb;II)Z",
      garbageValue = "-839348962"
   )
   @Export("decodeRegionHash")
   static boolean decodeRegionHash(PacketBuffer var0, int var1) {
      int var2 = var0.getBits(2);
      int var3;
      int var4;
      int var7;
      int var8;
      int var9;
      int var10;
      if(var2 == 0) {
         if(var0.getBits(1) != 0) {
            decodeRegionHash(var0, var1);
         }

         var3 = var0.getBits(13);
         var4 = var0.getBits(13);
         boolean var12 = var0.getBits(1) == 1;
         if(var12) {
            class97.field1501[++class97.field1500 - 1] = var1;
         }

         if(Client.cachedPlayers[var1] != null) {
            throw new RuntimeException();
         } else {
            Player var6 = Client.cachedPlayers[var1] = new Player();
            var6.field901 = var1;
            if(class97.field1492[var1] != null) {
               var6.decodeApperance(class97.field1492[var1]);
            }

            var6.orientation = class97.field1496[var1];
            var6.interacting = class97.field1499[var1];
            var7 = class97.field1497[var1];
            var8 = var7 >> 28;
            var9 = var7 >> 14 & 255;
            var10 = var7 & 255;
            var6.field1262[0] = class97.field1491[var1];
            var6.field900 = (byte)var8;
            var6.method1168((var9 << 13) + var3 - class25.baseX, (var10 << 13) + var4 - ScriptEvent.baseY);
            var6.field902 = false;
            return true;
         }
      } else if(var2 == 1) {
         var3 = var0.getBits(2);
         var4 = class97.field1497[var1];
         class97.field1497[var1] = (var4 & 268435455) + (((var4 >> 28) + var3 & 3) << 28);
         return false;
      } else {
         int var5;
         int var11;
         if(var2 == 2) {
            var3 = var0.getBits(5);
            var4 = var3 >> 3;
            var5 = var3 & 7;
            var11 = class97.field1497[var1];
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

            class97.field1497[var1] = (var8 << 14) + var9 + (var7 << 28);
            return false;
         } else {
            var3 = var0.getBits(18);
            var4 = var3 >> 16;
            var5 = var3 >> 8 & 255;
            var11 = var3 & 255;
            var7 = class97.field1497[var1];
            var8 = (var7 >> 28) + var4 & 3;
            var9 = var5 + (var7 >> 14) & 255;
            var10 = var11 + var7 & 255;
            class97.field1497[var1] = (var9 << 14) + var10 + (var8 << 28);
            return false;
         }
      }
   }
}
