import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InvalidClassException;
import java.io.ObjectInputStream;
import java.io.OptionalDataException;
import java.io.StreamCorruptedException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.zip.CRC32;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ff")
public class class171 extends class170 {
   @ObfuscatedName("e")
   volatile boolean[] field2736;
   @ObfuscatedName("ah")
   @ObfuscatedGetter(
      intValue = 789234533
   )
   int field2737;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -756203341
   )
   int field2738;
   @ObfuscatedName("v")
   volatile boolean field2739 = false;
   @ObfuscatedName("l")
   boolean field2740 = false;
   @ObfuscatedName("i")
   class137 field2741;
   @ObfuscatedName("j")
   static CRC32 field2742 = new CRC32();
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      intValue = 427291425
   )
   int field2743;
   @ObfuscatedName("c")
   class137 field2744;
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      intValue = 743803595
   )
   int field2745 = -1;

   @ObfuscatedName("co")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-431356487"
   )
   public int method3334() {
      if(this.field2739) {
         return 100;
      } else if(super.field2733 != null) {
         return 99;
      } else {
         int var1 = NPCComposition.method811(255, this.field2738);
         if(var1 >= 100) {
            var1 = 99;
         }

         return var1;
      }
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1822115260"
   )
   void vmethod3335(int var1) {
      int var2 = this.field2738;
      long var3 = (long)(var1 + (var2 << 16));
      class175 var5 = (class175)class174.field2770.method3775(var3);
      if(null != var5) {
         class174.field2769.method3873(var5);
      }

   }

   public class171(class137 var1, class137 var2, int var3, boolean var4, boolean var5, boolean var6) {
      super(var4, var5);
      this.field2744 = var1;
      this.field2741 = var2;
      this.field2738 = var3;
      this.field2740 = var6;
      int var8 = this.field2738;
      if(MessageNode.field781 != null) {
         MessageNode.field781.offset = 8 * var8 + 5;
         int var9 = MessageNode.field781.method2526();
         int var10 = MessageNode.field781.method2526();
         this.method3347(var9, var10);
      } else {
         XClanMember.method590((class171)null, 255, 255, 0, (byte)0, true);
         class174.field2778[var8] = this;
      }

   }

   @ObfuscatedName("cl")
   @ObfuscatedSignature(
      signature = "(I[BZZI)V",
      garbageValue = "1411344927"
   )
   public void method3336(int var1, byte[] var2, boolean var3, boolean var4) {
      if(var3) {
         if(this.field2739) {
            throw new RuntimeException();
         }

         if(null != this.field2741) {
            class38.method766(this.field2738, var2, this.field2741);
         }

         this.method3249(var2);
         this.method3367();
      } else {
         var2[var2.length - 2] = (byte)(super.field2720[var1] >> 8);
         var2[var2.length - 1] = (byte)super.field2720[var1];
         if(null != this.field2744) {
            class137 var5 = this.field2744;
            class172 var6 = new class172();
            var6.field2758 = 0;
            var6.hash = (long)var1;
            var6.field2757 = var2;
            var6.field2750 = var5;
            Deque var7 = class173.field2760;
            synchronized(class173.field2760) {
               class173.field2760.method3801(var6);
            }

            SecondaryBufferProvider.method1647();
            this.field2736[var1] = true;
         }

         if(var4) {
            super.field2733[var1] = class134.method2841(var2, false);
         }
      }

   }

   @ObfuscatedName("ce")
   @ObfuscatedSignature(
      signature = "(Lclass137;I[BZI)V",
      garbageValue = "999601588"
   )
   void method3337(class137 var1, int var2, byte[] var3, boolean var4) {
      int var5;
      if(var1 == this.field2741) {
         if(this.field2739) {
            throw new RuntimeException();
         }

         if(var3 == null) {
            XClanMember.method590(this, 255, this.field2738, this.field2743, (byte)0, true);
            return;
         }

         field2742.reset();
         field2742.update(var3, 0, var3.length);
         var5 = (int)field2742.getValue();
         Buffer var6 = new Buffer(class155.method3145(var3));
         int var7 = var6.method2481();
         if(var7 != 5 && var7 != 6) {
            throw new RuntimeException(var7 + "," + this.field2738 + "," + var2);
         }

         int var8 = 0;
         if(var7 >= 6) {
            var8 = var6.method2526();
         }

         if(var5 != this.field2743 || this.field2737 != var8) {
            XClanMember.method590(this, 255, this.field2738, this.field2743, (byte)0, true);
            return;
         }

         this.method3249(var3);
         this.method3367();
      } else {
         if(!var4 && this.field2745 == var2) {
            this.field2739 = true;
         }

         if(null == var3 || var3.length <= 2) {
            this.field2736[var2] = false;
            if(this.field2740 || var4) {
               XClanMember.method590(this, this.field2738, var2, super.field2725[var2], (byte)2, var4);
            }

            return;
         }

         field2742.reset();
         field2742.update(var3, 0, var3.length - 2);
         var5 = (int)field2742.getValue();
         int var9 = (var3[var3.length - 1] & 255) + ((var3[var3.length - 2] & 255) << 8);
         if(super.field2725[var2] != var5 || super.field2720[var2] != var9) {
            this.field2736[var2] = false;
            if(this.field2740 || var4) {
               XClanMember.method590(this, this.field2738, var2, super.field2725[var2], (byte)2, var4);
            }

            return;
         }

         this.field2736[var2] = true;
         if(var4) {
            super.field2733[var2] = class134.method2841(var3, false);
         }
      }

   }

   @ObfuscatedName("cc")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "1656431429"
   )
   int method3339(int var1) {
      return super.field2733[var1] != null?100:(this.field2736[var1]?100:NPCComposition.method811(this.field2738, var1));
   }

   @ObfuscatedName("cr")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-95"
   )
   public int method3340() {
      int var1 = 0;
      int var2 = 0;

      int var3;
      for(var3 = 0; var3 < super.field2733.length; ++var3) {
         if(super.field2724[var3] > 0) {
            var1 += 100;
            var2 += this.method3339(var3);
         }
      }

      if(var1 == 0) {
         return 100;
      } else {
         var3 = 100 * var2 / var1;
         return var3;
      }
   }

   @ObfuscatedName("dt")
   @ObfuscatedSignature(
      signature = "(IIII)LWidgetNode;",
      garbageValue = "-150231774"
   )
   static final WidgetNode method3341(int var0, int var1, int var2) {
      WidgetNode var3 = new WidgetNode();
      var3.id = var1;
      var3.field54 = var2;
      Client.componentTable.method3776(var3, (long)var0);
      ObjectComposition.method856(var1);
      Widget var4 = class92.method2078(var0);
      class32.method685(var4);
      if(Client.field432 != null) {
         class32.method685(Client.field432);
         Client.field432 = null;
      }

      class0.method2();
      Projectile.method99(Widget.widgets[var0 >> 16], var4, false);
      class129.method2805(var1);
      if(Client.widgetRoot != -1) {
         class32.method684(Client.widgetRoot, 1);
      }

      return var3;
   }

   @ObfuscatedName("cw")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-2103218764"
   )
   public void method3347(int var1, int var2) {
      this.field2743 = var1;
      this.field2737 = var2;
      if(this.field2741 != null) {
         TextureProvider.method2176(this.field2738, this.field2741, this);
      } else {
         XClanMember.method590(this, 255, this.field2738, this.field2743, (byte)0, true);
      }

   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(IS)V",
      garbageValue = "31902"
   )
   void vmethod3355(int var1) {
      if(null != this.field2744 && null != this.field2736 && this.field2736[var1]) {
         TextureProvider.method2176(var1, this.field2744, this);
      } else {
         XClanMember.method590(this, this.field2738, var1, super.field2725[var1], (byte)2, true);
      }

   }

   @ObfuscatedName("cy")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2123207918"
   )
   void method3367() {
      this.field2736 = new boolean[super.field2733.length];

      int var1;
      for(var1 = 0; var1 < this.field2736.length; ++var1) {
         this.field2736[var1] = false;
      }

      if(this.field2744 == null) {
         this.field2739 = true;
      } else {
         this.field2745 = -1;

         for(var1 = 0; var1 < this.field2736.length; ++var1) {
            if(super.field2724[var1] > 0) {
               class137 var2 = this.field2744;
               class172 var4 = new class172();
               var4.field2758 = 1;
               var4.hash = (long)var1;
               var4.field2750 = var2;
               var4.field2751 = this;
               Deque var5 = class173.field2760;
               synchronized(class173.field2760) {
                  class173.field2760.method3801(var4);
               }

               SecondaryBufferProvider.method1647();
               this.field2745 = var1;
            }
         }

         if(this.field2745 == -1) {
            this.field2739 = true;
         }

      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Lclass125;I)V",
      garbageValue = "-1456761953"
   )
   public static void method3368(class125 var0) {
      ClassInfo var1 = (ClassInfo)class214.field3181.method3850();
      if(var1 != null) {
         int var2 = var0.offset;
         var0.method2642(var1.field3173);

         for(int var3 = 0; var3 < var1.field3171; ++var3) {
            if(var1.field3176[var3] != 0) {
               var0.method2467(var1.field3176[var3]);
            } else {
               try {
                  int var4 = var1.field3172[var3];
                  Field var5;
                  int var6;
                  if(var4 == 0) {
                     var5 = var1.fields[var3];
                     var6 = var5.getInt((Object)null);
                     var0.method2467(0);
                     var0.method2642(var6);
                  } else if(var4 == 1) {
                     var5 = var1.fields[var3];
                     var5.setInt((Object)null, var1.field3175[var3]);
                     var0.method2467(0);
                  } else if(var4 == 2) {
                     var5 = var1.fields[var3];
                     var6 = var5.getModifiers();
                     var0.method2467(0);
                     var0.method2642(var6);
                  }

                  Method var25;
                  if(var4 != 3) {
                     if(var4 == 4) {
                        var25 = var1.methods[var3];
                        var6 = var25.getModifiers();
                        var0.method2467(0);
                        var0.method2642(var6);
                     }
                  } else {
                     var25 = var1.methods[var3];
                     byte[][] var10 = var1.args[var3];
                     Object[] var7 = new Object[var10.length];

                     for(int var8 = 0; var8 < var10.length; ++var8) {
                        ObjectInputStream var9 = new ObjectInputStream(new ByteArrayInputStream(var10[var8]));
                        var7[var8] = var9.readObject();
                     }

                     Object var11 = var25.invoke((Object)null, var7);
                     if(null == var11) {
                        var0.method2467(0);
                     } else if(var11 instanceof Number) {
                        var0.method2467(1);
                        var0.method2607(((Number)var11).longValue());
                     } else if(var11 instanceof String) {
                        var0.method2467(2);
                        var0.method2472((String)var11);
                     } else {
                        var0.method2467(4);
                     }
                  }
               } catch (ClassNotFoundException var13) {
                  var0.method2467(-10);
               } catch (InvalidClassException var14) {
                  var0.method2467(-11);
               } catch (StreamCorruptedException var15) {
                  var0.method2467(-12);
               } catch (OptionalDataException var16) {
                  var0.method2467(-13);
               } catch (IllegalAccessException var17) {
                  var0.method2467(-14);
               } catch (IllegalArgumentException var18) {
                  var0.method2467(-15);
               } catch (InvocationTargetException var19) {
                  var0.method2467(-16);
               } catch (SecurityException var20) {
                  var0.method2467(-17);
               } catch (IOException var21) {
                  var0.method2467(-18);
               } catch (NullPointerException var22) {
                  var0.method2467(-19);
               } catch (Exception var23) {
                  var0.method2467(-20);
               } catch (Throwable var24) {
                  var0.method2467(-21);
               }
            }
         }

         var0.method2489(var2);
         var1.unlink();
      }
   }
}
