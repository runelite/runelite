import java.awt.Image;
import java.io.IOException;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ff")
public class class178 {
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1395517881
   )
   final int field2652;
   @ObfuscatedName("d")
   static int[] field2653;
   @ObfuscatedName("i")
   static final class178 field2654 = new class178("RC", 1);
   @ObfuscatedName("a")
   static final class178 field2655 = new class178("WIP", 2);
   @ObfuscatedName("f")
   public final String field2656;
   @ObfuscatedName("x")
   static final class178 field2657 = new class178("BUILDLIVE", 3);
   @ObfuscatedName("ql")
   protected static Image field2658;
   @ObfuscatedName("u")
   static final class178 field2659 = new class178("LIVE", 0);

   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "0"
   )
   class178(String var1, int var2) {
      this.field2656 = var1;
      this.field2652 = var2;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "45"
   )
   public static boolean method3253() {
      long var0 = class9.method117();
      int var2 = (int)(var0 - class185.field2721);
      class185.field2721 = var0;
      if(var2 > 200) {
         var2 = 200;
      }

      class185.field2722 += var2;
      if(class185.field2732 == 0 && class185.field2741 == 0 && class185.field2734 == 0 && class185.field2725 == 0) {
         return true;
      } else if(null == class185.field2737) {
         return false;
      } else {
         try {
            if(class185.field2722 > 30000) {
               throw new IOException();
            } else {
               class181 var3;
               Buffer var4;
               while(class185.field2741 < 20 && class185.field2725 > 0) {
                  var3 = (class181)class185.field2724.method2344();
                  var4 = new Buffer(4);
                  var4.method2760(1);
                  var4.method2914((int)var3.hash);
                  class185.field2737.method2018(var4.payload, 0, 4);
                  class185.field2726.method2340(var3, var3.hash);
                  --class185.field2725;
                  ++class185.field2741;
               }

               while(class185.field2732 < 20 && class185.field2734 > 0) {
                  var3 = (class181)class185.field2728.method2281();
                  var4 = new Buffer(4);
                  var4.method2760(0);
                  var4.method2914((int)var3.hash);
                  class185.field2737.method2018(var4.payload, 0, 4);
                  var3.method2413();
                  class185.field2731.method2340(var3, var3.hash);
                  --class185.field2734;
                  ++class185.field2732;
               }

               for(int var15 = 0; var15 < 100; ++var15) {
                  int var16 = class185.field2737.method2017();
                  if(var16 < 0) {
                     throw new IOException();
                  }

                  if(var16 == 0) {
                     break;
                  }

                  class185.field2722 = 0;
                  byte var5 = 0;
                  if(null == class185.field2723) {
                     var5 = 8;
                  } else if(class185.field2743 == 0) {
                     var5 = 1;
                  }

                  int var6;
                  int var7;
                  int var8;
                  int var10;
                  if(var5 > 0) {
                     var6 = var5 - class185.field2735.offset;
                     if(var6 > var16) {
                        var6 = var16;
                     }

                     class185.field2737.method2014(class185.field2735.payload, class185.field2735.offset, var6);
                     if(class185.field2739 != 0) {
                        for(var7 = 0; var7 < var6; ++var7) {
                           class185.field2735.payload[class185.field2735.offset + var7] ^= class185.field2739;
                        }
                     }

                     class185.field2735.offset += var6;
                     if(class185.field2735.offset < var5) {
                        break;
                     }

                     if(class185.field2723 == null) {
                        class185.field2735.offset = 0;
                        var7 = class185.field2735.readUnsignedByte();
                        var8 = class185.field2735.readUnsignedShort();
                        int var9 = class185.field2735.readUnsignedByte();
                        var10 = class185.field2735.method2780();
                        long var11 = (long)(var8 + (var7 << 16));
                        class181 var13 = (class181)class185.field2726.method2339(var11);
                        class185.field2733 = true;
                        if(var13 == null) {
                           var13 = (class181)class185.field2731.method2339(var11);
                           class185.field2733 = false;
                        }

                        if(var13 == null) {
                           throw new IOException();
                        }

                        int var14 = var9 == 0?5:9;
                        class185.field2723 = var13;
                        class22.field238 = new Buffer(class185.field2723.field2677 + var10 + var14);
                        class22.field238.method2760(var9);
                        class22.field238.method2763(var10);
                        class185.field2743 = 8;
                        class185.field2735.offset = 0;
                     } else if(class185.field2743 == 0) {
                        if(class185.field2735.payload[0] == -1) {
                           class185.field2743 = 1;
                           class185.field2735.offset = 0;
                        } else {
                           class185.field2723 = null;
                        }
                     }
                  } else {
                     var6 = class22.field238.payload.length - class185.field2723.field2677;
                     var7 = 512 - class185.field2743;
                     if(var7 > var6 - class22.field238.offset) {
                        var7 = var6 - class22.field238.offset;
                     }

                     if(var7 > var16) {
                        var7 = var16;
                     }

                     class185.field2737.method2014(class22.field238.payload, class22.field238.offset, var7);
                     if(class185.field2739 != 0) {
                        for(var8 = 0; var8 < var7; ++var8) {
                           class22.field238.payload[class22.field238.offset + var8] ^= class185.field2739;
                        }
                     }

                     class22.field238.offset += var7;
                     class185.field2743 += var7;
                     if(var6 == class22.field238.offset) {
                        if(class185.field2723.hash == 16711935L) {
                           ChatMessages.field905 = class22.field238;

                           for(var8 = 0; var8 < 256; ++var8) {
                              class184 var17 = class185.field2738[var8];
                              if(var17 != null) {
                                 ChatMessages.field905.offset = 5 + 8 * var8;
                                 var10 = ChatMessages.field905.method2780();
                                 int var21 = ChatMessages.field905.method2780();
                                 var17.method3359(var10, var21);
                              }
                           }
                        } else {
                           class185.field2729.reset();
                           class185.field2729.update(class22.field238.payload, 0, var6);
                           var8 = (int)class185.field2729.getValue();
                           if(class185.field2723.field2678 != var8) {
                              try {
                                 class185.field2737.method2026();
                              } catch (Exception var19) {
                                 ;
                              }

                              ++class185.field2740;
                              class185.field2737 = null;
                              class185.field2739 = (byte)((int)(Math.random() * 255.0D + 1.0D));
                              return false;
                           }

                           class185.field2740 = 0;
                           class185.field2736 = 0;
                           class185.field2723.field2680.method3360((int)(class185.field2723.hash & 65535L), class22.field238.payload, 16711680L == (class185.field2723.hash & 16711680L), class185.field2733);
                        }

                        class185.field2723.unlink();
                        if(class185.field2733) {
                           --class185.field2741;
                        } else {
                           --class185.field2732;
                        }

                        class185.field2743 = 0;
                        class185.field2723 = null;
                        class22.field238 = null;
                     } else {
                        if(class185.field2743 != 512) {
                           break;
                        }

                        class185.field2743 = 0;
                     }
                  }
               }

               return true;
            }
         } catch (IOException var20) {
            try {
               class185.field2737.method2026();
            } catch (Exception var18) {
               ;
            }

            ++class185.field2736;
            class185.field2737 = null;
            return false;
         }
      }
   }
}
