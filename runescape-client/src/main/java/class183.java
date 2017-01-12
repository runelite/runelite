import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ge")
public class class183 implements Runnable {
   @ObfuscatedName("x")
   static Deque field2703 = new Deque();
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -590669441
   )
   static int field2704 = 0;
   @ObfuscatedName("u")
   static Deque field2705 = new Deque();
   @ObfuscatedName("a")
   static Object field2706 = new Object();
   @ObfuscatedName("dn")
   @Export("mapRegions")
   static int[] mapRegions;

   public void run() {
      try {
         while(true) {
            Deque var2 = field2705;
            class180 var1;
            synchronized(field2705) {
               var1 = (class180)field2705.method2391();
            }

            Object var14;
            if(null != var1) {
               if(var1.field2673 == 0) {
                  var1.field2670.method2224((int)var1.hash, var1.field2675, var1.field2675.length);
                  var2 = field2705;
                  synchronized(field2705) {
                     var1.unlink();
                  }
               } else if(var1.field2673 == 1) {
                  var1.field2675 = var1.field2670.method2227((int)var1.hash);
                  var2 = field2705;
                  synchronized(field2705) {
                     field2703.method2394(var1);
                  }
               }

               var14 = field2706;
               synchronized(field2706) {
                  if(field2704 <= 1) {
                     field2704 = 0;
                     field2706.notifyAll();
                     return;
                  }

                  field2704 = 600;
               }
            } else {
               VertexNormal.method1598(100L);
               var14 = field2706;
               synchronized(field2706) {
                  if(field2704 <= 1) {
                     field2704 = 0;
                     field2706.notifyAll();
                     return;
                  }

                  --field2704;
               }
            }
         }
      } catch (Exception var13) {
         class174.method3240((String)null, var13);
      }
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "([BIII)Ljava/lang/String;",
      garbageValue = "1946276839"
   )
   public static String method3346(byte[] var0, int var1, int var2) {
      char[] var3 = new char[var2];
      int var4 = 0;

      for(int var5 = 0; var5 < var2; ++var5) {
         int var6 = var0[var5 + var1] & 255;
         if(var6 != 0) {
            if(var6 >= 128 && var6 < 160) {
               char var7 = class203.field3061[var6 - 128];
               if(var7 == 0) {
                  var7 = 63;
               }

               var6 = var7;
            }

            var3[var4++] = (char)var6;
         }
      }

      return new String(var3, 0, var4);
   }

   @ObfuscatedName("dl")
   @ObfuscatedSignature(
      signature = "(IIIIIIII)V",
      garbageValue = "1772403928"
   )
   static final void method3352(int var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      if(class94.method1870(var0)) {
         Frames.method1850(Widget.widgets[var0], -1, var1, var2, var3, var4, var5, var6);
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;I)[B",
      garbageValue = "118303941"
   )
   public static byte[] method3353(CharSequence var0) {
      int var1 = var0.length();
      byte[] var2 = new byte[var1];

      for(int var3 = 0; var3 < var1; ++var3) {
         char var4 = var0.charAt(var3);
         if((var4 <= 0 || var4 >= 128) && (var4 < 160 || var4 > 255)) {
            if(var4 == 8364) {
               var2[var3] = -128;
            } else if(var4 == 8218) {
               var2[var3] = -126;
            } else if(var4 == 402) {
               var2[var3] = -125;
            } else if(var4 == 8222) {
               var2[var3] = -124;
            } else if(var4 == 8230) {
               var2[var3] = -123;
            } else if(var4 == 8224) {
               var2[var3] = -122;
            } else if(var4 == 8225) {
               var2[var3] = -121;
            } else if(var4 == 710) {
               var2[var3] = -120;
            } else if(var4 == 8240) {
               var2[var3] = -119;
            } else if(var4 == 352) {
               var2[var3] = -118;
            } else if(var4 == 8249) {
               var2[var3] = -117;
            } else if(var4 == 338) {
               var2[var3] = -116;
            } else if(var4 == 381) {
               var2[var3] = -114;
            } else if(var4 == 8216) {
               var2[var3] = -111;
            } else if(var4 == 8217) {
               var2[var3] = -110;
            } else if(var4 == 8220) {
               var2[var3] = -109;
            } else if(var4 == 8221) {
               var2[var3] = -108;
            } else if(var4 == 8226) {
               var2[var3] = -107;
            } else if(var4 == 8211) {
               var2[var3] = -106;
            } else if(var4 == 8212) {
               var2[var3] = -105;
            } else if(var4 == 732) {
               var2[var3] = -104;
            } else if(var4 == 8482) {
               var2[var3] = -103;
            } else if(var4 == 353) {
               var2[var3] = -102;
            } else if(var4 == 8250) {
               var2[var3] = -101;
            } else if(var4 == 339) {
               var2[var3] = -100;
            } else if(var4 == 382) {
               var2[var3] = -98;
            } else if(var4 == 376) {
               var2[var3] = -97;
            } else {
               var2[var3] = 63;
            }
         } else {
            var2[var3] = (byte)var4;
         }
      }

      return var2;
   }
}
