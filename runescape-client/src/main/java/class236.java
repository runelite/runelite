import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.Random;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ic")
public class class236 implements Runnable {
   @ObfuscatedName("w")
   static Object field3239;
   @ObfuscatedName("m")
   public static Deque field3240;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1337642935
   )
   static int field3241;
   @ObfuscatedName("p")
   public static Deque field3245;

   public void run() {
      try {
         while(true) {
            Deque var1 = field3245;
            Deque var3 = field3245;
            FileSystem var2;
            synchronized(field3245) {
               var2 = (FileSystem)field3245.method3487();
            }

            Object var4;
            Object var15;
            if(var2 != null) {
               Deque var16;
               if(var2.field3211 == 0) {
                  var2.index.method2903((int)var2.hash, var2.field3210, var2.field3210.length);
                  var1 = field3245;
                  var16 = field3245;
                  synchronized(field3245) {
                     var2.unlink();
                  }
               } else if(var2.field3211 == 1) {
                  var2.field3210 = var2.index.method2902((int)var2.hash);
                  var1 = field3245;
                  var16 = field3245;
                  synchronized(field3245) {
                     field3240.method3505(var2);
                  }
               }

               var15 = field3239;
               var4 = field3239;
               synchronized(field3239) {
                  if(field3241 <= 1) {
                     field3241 = 0;
                     field3239.notifyAll();
                     return;
                  }

                  field3241 = 600;
               }
            } else {
               class172.method3014(100L);
               var15 = field3239;
               var4 = field3239;
               synchronized(field3239) {
                  if(field3241 <= 1) {
                     field3241 = 0;
                     field3239.notifyAll();
                     return;
                  }

                  --field3241;
               }
            }
         }
      } catch (Exception var14) {
         class8.method43((String)null, var14);
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(JLjava/lang/String;I)I",
      garbageValue = "-1349636675"
   )
   static final int method4093(long var0, String var2) {
      Random var3 = new Random();
      Buffer var4 = new Buffer(128);
      Buffer var5 = new Buffer(128);
      int[] var6 = new int[]{var3.nextInt(), var3.nextInt(), (int)(var0 >> 32), (int)var0};
      var4.putByte(10);

      int var7;
      for(var7 = 0; var7 < 4; ++var7) {
         var4.putInt(var3.nextInt());
      }

      var4.putInt(var6[0]);
      var4.putInt(var6[1]);
      var4.putLong(var0);
      var4.putLong(0L);

      for(var7 = 0; var7 < 4; ++var7) {
         var4.putInt(var3.nextInt());
      }

      var4.method3054(class87.field1363, class87.field1367);
      var5.putByte(10);

      for(var7 = 0; var7 < 3; ++var7) {
         var5.putInt(var3.nextInt());
      }

      var5.putLong(var3.nextLong());
      var5.method3022(var3.nextLong());
      class268.method4754(var5);
      var5.putLong(var3.nextLong());
      var5.method3054(class87.field1363, class87.field1367);
      var7 = Friend.method1023(var2);
      if(var7 % 8 != 0) {
         var7 += 8 - var7 % 8;
      }

      Buffer var8 = new Buffer(var7);
      var8.method3125(var2);
      var8.offset = var7;
      var8.encryptXtea2(var6);
      Buffer var9 = new Buffer(var5.offset + var4.offset + 5 + var8.offset);
      var9.putByte(2);
      var9.putByte(var4.offset);
      var9.putBytes(var4.payload, 0, var4.offset);
      var9.putByte(var5.offset);
      var9.putBytes(var5.payload, 0, var5.offset);
      var9.putShort(var8.offset);
      var9.putBytes(var8.payload, 0, var8.offset);
      String var10 = class214.method3869(var9.payload);

      try {
         URL var11 = new URL(class73.method1066("services", false) + "m=accountappeal/login.ws");
         URLConnection var12 = var11.openConnection();
         var12.setDoInput(true);
         var12.setDoOutput(true);
         var12.setConnectTimeout(5000);
         OutputStreamWriter var13 = new OutputStreamWriter(var12.getOutputStream());
         var13.write("data2=" + class54.method747(var10) + "&dest=" + class54.method747("passwordchoice.ws"));
         var13.flush();
         InputStream var14 = var12.getInputStream();
         var9 = new Buffer(new byte[1000]);

         do {
            int var15 = var14.read(var9.payload, var9.offset, 1000 - var9.offset);
            if(var15 == -1) {
               var13.close();
               var14.close();
               String var16 = new String(var9.payload);
               if(var16.startsWith("OFFLINE")) {
                  return 4;
               } else if(var16.startsWith("WRONG")) {
                  return 7;
               } else if(var16.startsWith("RELOAD")) {
                  return 3;
               } else if(var16.startsWith("Not permitted for social network accounts.")) {
                  return 6;
               } else {
                  var9.decryptXtea(var6);

                  while(var9.offset > 0 && var9.payload[var9.offset - 1] == 0) {
                     --var9.offset;
                  }

                  var16 = new String(var9.payload, 0, var9.offset);
                  if(class277.method4798(var16)) {
                     class20.method164(var16, true, false);
                     return 2;
                  } else {
                     return 5;
                  }
               }
            }

            var9.offset += var15;
         } while(var9.offset < 1000);

         return 5;
      } catch (Throwable var17) {
         var17.printStackTrace();
         return 5;
      }
   }

   static {
      field3245 = new Deque();
      field3240 = new Deque();
      field3241 = 0;
      field3239 = new Object();
   }
}
