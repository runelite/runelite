import java.io.File;
import java.io.IOException;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ga")
public class class183 implements Runnable {
   @ObfuscatedName("j")
   static Deque field2717 = new Deque();
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1972462037
   )
   static int field2718 = 0;
   @ObfuscatedName("x")
   static Deque field2719 = new Deque();
   @ObfuscatedName("d")
   static Object field2725 = new Object();

   public void run() {
      try {
         while(true) {
            Deque var2 = field2719;
            class180 var1;
            synchronized(field2719) {
               var1 = (class180)field2719.method2448();
            }

            Object var14;
            if(var1 != null) {
               if(var1.field2690 == 0) {
                  var1.field2683.method2283((int)var1.hash, var1.field2681, var1.field2681.length);
                  var2 = field2719;
                  synchronized(field2719) {
                     var1.unlink();
                  }
               } else if(var1.field2690 == 1) {
                  var1.field2681 = var1.field2683.method2282((int)var1.hash);
                  var2 = field2719;
                  synchronized(field2719) {
                     field2717.method2458(var1);
                  }
               }

               var14 = field2725;
               synchronized(field2725) {
                  if(field2718 <= 1) {
                     field2718 = 0;
                     field2725.notifyAll();
                     return;
                  }

                  field2718 = 600;
               }
            } else {
               class140.method2660(100L);
               var14 = field2725;
               synchronized(field2725) {
                  if(field2718 <= 1) {
                     field2718 = 0;
                     field2725.notifyAll();
                     return;
                  }

                  --field2718;
               }
            }
         }
      } catch (Exception var13) {
         class31.method703((String)null, var13);
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;II)Ljava/io/File;",
      garbageValue = "563895933"
   )
   public static File method3404(String var0, String var1, int var2) {
      String var3 = var2 == 0?"":"" + var2;
      class104.field1697 = new File(class30.field724, "jagex_cl_" + var0 + "_" + var1 + var3 + ".dat");
      String var4 = null;
      String var5 = null;
      boolean var6 = false;
      File var22;
      if(class104.field1697.exists()) {
         try {
            FileOnDisk var7 = new FileOnDisk(class104.field1697, "rw", 10000L);

            Buffer var8;
            int var9;
            for(var8 = new Buffer((int)var7.method1480()); var8.offset < var8.payload.length; var8.offset += var9) {
               var9 = var7.method1476(var8.payload, var8.offset, var8.payload.length - var8.offset);
               if(var9 == -1) {
                  throw new IOException();
               }
            }

            var8.offset = 0;
            var9 = var8.readUnsignedByte();
            if(var9 < 1 || var9 > 3) {
               throw new IOException("" + var9);
            }

            int var10 = 0;
            if(var9 > 1) {
               var10 = var8.readUnsignedByte();
            }

            if(var9 <= 2) {
               var4 = var8.method2973();
               if(var10 == 1) {
                  var5 = var8.method2973();
               }
            } else {
               var4 = var8.method2848();
               if(var10 == 1) {
                  var5 = var8.method2848();
               }
            }

            var7.method1479();
         } catch (IOException var20) {
            var20.printStackTrace();
         }

         if(null != var4) {
            var22 = new File(var4);
            if(!var22.exists()) {
               var4 = null;
            }
         }

         if(null != var4) {
            var22 = new File(var4, "test.dat");
            if(!XClanMember.method278(var22, true)) {
               var4 = null;
            }
         }
      }

      if(null == var4 && var2 == 0) {
         label120:
         for(int var15 = 0; var15 < class206.field3100.length; ++var15) {
            for(int var16 = 0; var16 < FrameMap.field1476.length; ++var16) {
               File var17 = new File(FrameMap.field1476[var16] + class206.field3100[var15] + File.separatorChar + var0 + File.separatorChar);
               if(var17.exists() && XClanMember.method278(new File(var17, "test.dat"), true)) {
                  var4 = var17.toString();
                  var6 = true;
                  break label120;
               }
            }
         }
      }

      if(var4 == null) {
         var4 = class30.field724 + File.separatorChar + "jagexcache" + var3 + File.separatorChar + var0 + File.separatorChar + var1 + File.separatorChar;
         var6 = true;
      }

      if(null != var5) {
         File var21 = new File(var5);
         var22 = new File(var4);

         try {
            File[] var23 = var21.listFiles();
            File[] var18 = var23;

            for(int var11 = 0; var11 < var18.length; ++var11) {
               File var12 = var18[var11];
               File var13 = new File(var22, var12.getName());
               boolean var14 = var12.renameTo(var13);
               if(!var14) {
                  throw new IOException();
               }
            }
         } catch (Exception var19) {
            var19.printStackTrace();
         }

         var6 = true;
      }

      if(var6) {
         Script.method972(new File(var4), (File)null);
      }

      return new File(var4);
   }
}
