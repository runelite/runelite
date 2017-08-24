import java.awt.Component;
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

@ObfuscatedName("hh")
public class class208 extends Node {
   @ObfuscatedName("b")
   int[] field2587;
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "[Ldp;"
   )
   class106[] field2581;
   @ObfuscatedName("a")
   short[] field2590;
   @ObfuscatedName("r")
   byte[] field2588;
   @ObfuscatedName("o")
   byte[] field2584;
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "[Lgh;"
   )
   class203[] field2591;
   @ObfuscatedName("q")
   byte[] field2586;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1196503813
   )
   int field2583;

   class208(byte[] var1) {
      this.field2581 = new class106[128];
      this.field2590 = new short[128];
      this.field2588 = new byte[128];
      this.field2584 = new byte[128];
      this.field2591 = new class203[128];
      this.field2586 = new byte[128];
      this.field2587 = new int[128];
      Buffer var2 = new Buffer(var1);

      int var3;
      for(var3 = 0; 0 != var2.payload[var3 + var2.offset]; ++var3) {
         ;
      }

      byte[] var4 = new byte[var3];

      int var5;
      for(var5 = 0; var5 < var3; ++var5) {
         var4[var5] = var2.readByte();
      }

      ++var2.offset;
      ++var3;
      var5 = var2.offset;
      var2.offset += var3;

      int var6;
      for(var6 = 0; var2.payload[var6 + var2.offset] != 0; ++var6) {
         ;
      }

      byte[] var7 = new byte[var6];

      int var8;
      for(var8 = 0; var8 < var6; ++var8) {
         var7[var8] = var2.readByte();
      }

      ++var2.offset;
      ++var6;
      var8 = var2.offset;
      var2.offset += var6;

      int var9;
      for(var9 = 0; var2.payload[var9 + var2.offset] != 0; ++var9) {
         ;
      }

      byte[] var10 = new byte[var9];

      for(int var11 = 0; var11 < var9; ++var11) {
         var10[var11] = var2.readByte();
      }

      ++var2.offset;
      ++var9;
      byte[] var38 = new byte[var9];
      int var12;
      int var14;
      if(var9 > 1) {
         var38[1] = 1;
         int var13 = 1;
         var12 = 2;

         for(var14 = 2; var14 < var9; ++var14) {
            int var15 = var2.readUnsignedByte();
            if(var15 == 0) {
               var13 = var12++;
            } else {
               if(var15 <= var13) {
                  --var15;
               }

               var13 = var15;
            }

            var38[var14] = (byte)var13;
         }
      } else {
         var12 = var9;
      }

      class203[] var39 = new class203[var12];

      class203 var40;
      for(var14 = 0; var14 < var39.length; ++var14) {
         var40 = var39[var14] = new class203();
         int var16 = var2.readUnsignedByte();
         if(var16 > 0) {
            var40.field2495 = new byte[var16 * 2];
         }

         var16 = var2.readUnsignedByte();
         if(var16 > 0) {
            var40.field2494 = new byte[2 + var16 * 2];
            var40.field2494[1] = 64;
         }
      }

      var14 = var2.readUnsignedByte();
      byte[] var47 = var14 > 0?new byte[var14 * 2]:null;
      var14 = var2.readUnsignedByte();
      byte[] var41 = var14 > 0?new byte[var14 * 2]:null;

      int var17;
      for(var17 = 0; var2.payload[var17 + var2.offset] != 0; ++var17) {
         ;
      }

      byte[] var18 = new byte[var17];

      int var19;
      for(var19 = 0; var19 < var17; ++var19) {
         var18[var19] = var2.readByte();
      }

      ++var2.offset;
      ++var17;
      var19 = 0;

      int var20;
      for(var20 = 0; var20 < 128; ++var20) {
         var19 += var2.readUnsignedByte();
         this.field2590[var20] = (short)var19;
      }

      var19 = 0;

      for(var20 = 0; var20 < 128; ++var20) {
         var19 += var2.readUnsignedByte();
         this.field2590[var20] = (short)(this.field2590[var20] + (var19 << 8));
      }

      var20 = 0;
      int var21 = 0;
      int var22 = 0;

      int var23;
      for(var23 = 0; var23 < 128; ++var23) {
         if(var20 == 0) {
            if(var21 < var18.length) {
               var20 = var18[var21++];
            } else {
               var20 = -1;
            }

            var22 = var2.readVarInt();
         }

         this.field2590[var23] = (short)(this.field2590[var23] + ((var22 - 1 & 2) << 14));
         this.field2587[var23] = var22;
         --var20;
      }

      var20 = 0;
      var21 = 0;
      var23 = 0;

      int var24;
      for(var24 = 0; var24 < 128; ++var24) {
         if(this.field2587[var24] != 0) {
            if(var20 == 0) {
               if(var21 < var4.length) {
                  var20 = var4[var21++];
               } else {
                  var20 = -1;
               }

               var23 = var2.payload[var5++] - 1;
            }

            this.field2586[var24] = (byte)var23;
            --var20;
         }
      }

      var20 = 0;
      var21 = 0;
      var24 = 0;

      for(int var25 = 0; var25 < 128; ++var25) {
         if(this.field2587[var25] != 0) {
            if(var20 == 0) {
               if(var21 < var7.length) {
                  var20 = var7[var21++];
               } else {
                  var20 = -1;
               }

               var24 = var2.payload[var8++] + 16 << 2;
            }

            this.field2584[var25] = (byte)var24;
            --var20;
         }
      }

      var20 = 0;
      var21 = 0;
      class203 var42 = null;

      int var26;
      for(var26 = 0; var26 < 128; ++var26) {
         if(this.field2587[var26] != 0) {
            if(var20 == 0) {
               var42 = var39[var38[var21]];
               if(var21 < var10.length) {
                  var20 = var10[var21++];
               } else {
                  var20 = -1;
               }
            }

            this.field2591[var26] = var42;
            --var20;
         }
      }

      var20 = 0;
      var21 = 0;
      var26 = 0;

      int var27;
      for(var27 = 0; var27 < 128; ++var27) {
         if(var20 == 0) {
            if(var21 < var18.length) {
               var20 = var18[var21++];
            } else {
               var20 = -1;
            }

            if(this.field2587[var27] > 0) {
               var26 = var2.readUnsignedByte() + 1;
            }
         }

         this.field2588[var27] = (byte)var26;
         --var20;
      }

      this.field2583 = var2.readUnsignedByte() + 1;

      class203 var28;
      int var29;
      for(var27 = 0; var27 < var12; ++var27) {
         var28 = var39[var27];
         if(var28.field2495 != null) {
            for(var29 = 1; var29 < var28.field2495.length; var29 += 2) {
               var28.field2495[var29] = var2.readByte();
            }
         }

         if(var28.field2494 != null) {
            for(var29 = 3; var29 < var28.field2494.length - 2; var29 += 2) {
               var28.field2494[var29] = var2.readByte();
            }
         }
      }

      if(var47 != null) {
         for(var27 = 1; var27 < var47.length; var27 += 2) {
            var47[var27] = var2.readByte();
         }
      }

      if(var41 != null) {
         for(var27 = 1; var27 < var41.length; var27 += 2) {
            var41[var27] = var2.readByte();
         }
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var28 = var39[var27];
         if(var28.field2494 != null) {
            var19 = 0;

            for(var29 = 2; var29 < var28.field2494.length; var29 += 2) {
               var19 = 1 + var19 + var2.readUnsignedByte();
               var28.field2494[var29] = (byte)var19;
            }
         }
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var28 = var39[var27];
         if(var28.field2495 != null) {
            var19 = 0;

            for(var29 = 2; var29 < var28.field2495.length; var29 += 2) {
               var19 = var19 + 1 + var2.readUnsignedByte();
               var28.field2495[var29] = (byte)var19;
            }
         }
      }

      byte var30;
      int var32;
      int var33;
      int var34;
      int var35;
      int var36;
      int var44;
      byte var46;
      if(var47 != null) {
         var19 = var2.readUnsignedByte();
         var47[0] = (byte)var19;

         for(var27 = 2; var27 < var47.length; var27 += 2) {
            var19 = 1 + var19 + var2.readUnsignedByte();
            var47[var27] = (byte)var19;
         }

         var46 = var47[0];
         byte var43 = var47[1];

         for(var29 = 0; var29 < var46; ++var29) {
            this.field2588[var29] = (byte)(32 + var43 * this.field2588[var29] >> 6);
         }

         for(var29 = 2; var29 < var47.length; var29 += 2) {
            var30 = var47[var29];
            byte var31 = var47[var29 + 1];
            var32 = (var30 - var46) / 2 + var43 * (var30 - var46);

            for(var33 = var46; var33 < var30; ++var33) {
               var35 = var30 - var46;
               var36 = var32 >>> 31;
               var34 = (var32 + var36) / var35 - var36;
               this.field2588[var33] = (byte)(var34 * this.field2588[var33] + 32 >> 6);
               var32 += var31 - var43;
            }

            var46 = var30;
            var43 = var31;
         }

         for(var44 = var46; var44 < 128; ++var44) {
            this.field2588[var44] = (byte)(var43 * this.field2588[var44] + 32 >> 6);
         }

         var40 = null;
      }

      if(var41 != null) {
         var19 = var2.readUnsignedByte();
         var41[0] = (byte)var19;

         for(var27 = 2; var27 < var41.length; var27 += 2) {
            var19 = var19 + 1 + var2.readUnsignedByte();
            var41[var27] = (byte)var19;
         }

         var46 = var41[0];
         int var49 = var41[1] << 1;

         for(var29 = 0; var29 < var46; ++var29) {
            var44 = var49 + (this.field2584[var29] & 255);
            if(var44 < 0) {
               var44 = 0;
            }

            if(var44 > 128) {
               var44 = 128;
            }

            this.field2584[var29] = (byte)var44;
         }

         int var45;
         for(var29 = 2; var29 < var41.length; var29 += 2) {
            var30 = var41[var29];
            var45 = var41[var29 + 1] << 1;
            var32 = var49 * (var30 - var46) + (var30 - var46) / 2;

            for(var33 = var46; var33 < var30; ++var33) {
               var35 = var30 - var46;
               var36 = var32 >>> 31;
               var34 = (var36 + var32) / var35 - var36;
               int var37 = var34 + (this.field2584[var33] & 255);
               if(var37 < 0) {
                  var37 = 0;
               }

               if(var37 > 128) {
                  var37 = 128;
               }

               this.field2584[var33] = (byte)var37;
               var32 += var45 - var49;
            }

            var46 = var30;
            var49 = var45;
         }

         for(var44 = var46; var44 < 128; ++var44) {
            var45 = var49 + (this.field2584[var44] & 255);
            if(var45 < 0) {
               var45 = 0;
            }

            if(var45 > 128) {
               var45 = 128;
            }

            this.field2584[var44] = (byte)var45;
         }

         Object var48 = null;
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var39[var27].field2502 = var2.readUnsignedByte();
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var28 = var39[var27];
         if(var28.field2495 != null) {
            var28.field2496 = var2.readUnsignedByte();
         }

         if(var28.field2494 != null) {
            var28.field2497 = var2.readUnsignedByte();
         }

         if(var28.field2502 > 0) {
            var28.field2498 = var2.readUnsignedByte();
         }
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var39[var27].field2500 = var2.readUnsignedByte();
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var28 = var39[var27];
         if(var28.field2500 > 0) {
            var28.field2499 = var2.readUnsignedByte();
         }
      }

      for(var27 = 0; var27 < var12; ++var27) {
         var28 = var39[var27];
         if(var28.field2499 > 0) {
            var28.field2501 = var2.readUnsignedByte();
         }
      }

   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "183009376"
   )
   void method3924() {
      this.field2587 = null;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Ldr;[B[II)Z",
      garbageValue = "-1321976717"
   )
   boolean method3923(class111 var1, byte[] var2, int[] var3) {
      boolean var4 = true;
      int var5 = 0;
      class106 var6 = null;

      for(int var7 = 0; var7 < 128; ++var7) {
         if(var2 == null || var2[var7] != 0) {
            int var8 = this.field2587[var7];
            if(var8 != 0) {
               if(var5 != var8) {
                  var5 = var8--;
                  if((var8 & 1) == 0) {
                     var6 = var1.method2084(var8 >> 2, var3);
                  } else {
                     var6 = var1.method2098(var8 >> 2, var3);
                  }

                  if(var6 == null) {
                     var4 = false;
                  }
               }

               if(var6 != null) {
                  this.field2581[var7] = var6;
                  this.field2587[var7] = 0;
               }
            }
         }
      }

      return var4;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;I)V",
      garbageValue = "-1179737545"
   )
   static void method3931(Component var0) {
      var0.removeMouseListener(MouseInput.mouse);
      var0.removeMouseMotionListener(MouseInput.mouse);
      var0.removeFocusListener(MouseInput.mouse);
      MouseInput.field744 = 0;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-82444426"
   )
   public static void method3930() {
      FloorUnderlayDefinition.underlays.reset();
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Lfn;B)V",
      garbageValue = "26"
   )
   @Export("encodeClassVerifier")
   public static void encodeClassVerifier(PacketBuffer var0) {
      ClassInfo var1 = (ClassInfo)class281.field3757.method3642();
      if(var1 != null) {
         int var2 = var0.offset;
         var0.putInt(var1.field3749);

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
                     Reflection.setInt(var5, (Object)null, var1.field3748[var3]);
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

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(IIIZIZI)V",
      garbageValue = "-1725622375"
   )
   static void method3922(int var0, int var1, int var2, boolean var3, int var4, boolean var5) {
      if(var0 < var1) {
         int var6 = (var0 + var1) / 2;
         int var7 = var0;
         World var8 = World.worldList[var6];
         World.worldList[var6] = World.worldList[var1];
         World.worldList[var1] = var8;

         for(int var9 = var0; var9 < var1; ++var9) {
            if(ScriptEvent.method1129(World.worldList[var9], var8, var2, var3, var4, var5) <= 0) {
               World var10 = World.worldList[var9];
               World.worldList[var9] = World.worldList[var7];
               World.worldList[var7++] = var10;
            }
         }

         World.worldList[var1] = World.worldList[var7];
         World.worldList[var7] = var8;
         method3922(var0, var7 - 1, var2, var3, var4, var5);
         method3922(var7 + 1, var1, var2, var3, var4, var5);
      }

   }
}
