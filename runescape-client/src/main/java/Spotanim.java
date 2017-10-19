import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Random;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("iz")
@Implements("Spotanim")
public class Spotanim extends CacheableNode {
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lgo;"
   )
   static NodeCache field3323;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lgo;"
   )
   @Export("spotanims")
   static NodeCache spotanims;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lip;"
   )
   public static IndexDataBase field3333;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -236911803
   )
   @Export("id")
   int id;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1109844119
   )
   public int field3325;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -2119226021
   )
   int field3332;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -650337775
   )
   int field3330;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 1612150537
   )
   int field3331;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 425499021
   )
   int field3329;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1060518919
   )
   int field3324;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -660562343
   )
   int field3334;
   @ObfuscatedName("e")
   short[] field3326;
   @ObfuscatedName("x")
   short[] field3328;
   @ObfuscatedName("d")
   short[] field3327;
   @ObfuscatedName("z")
   short[] field3322;

   static {
      spotanims = new NodeCache(64);
      field3323 = new NodeCache(30);
   }

   Spotanim() {
      this.field3325 = -1;
      this.field3330 = 128;
      this.field3331 = 128;
      this.field3329 = 0;
      this.field3324 = 0;
      this.field3334 = 0;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Lfz;II)V",
      garbageValue = "-380539028"
   )
   void method4403(Buffer var1, int var2) {
      if(var2 == 1) {
         this.field3332 = var1.readUnsignedShort();
      } else if(var2 == 2) {
         this.field3325 = var1.readUnsignedShort();
      } else if(var2 == 4) {
         this.field3330 = var1.readUnsignedShort();
      } else if(var2 == 5) {
         this.field3331 = var1.readUnsignedShort();
      } else if(var2 == 6) {
         this.field3329 = var1.readUnsignedShort();
      } else if(var2 == 7) {
         this.field3324 = var1.readUnsignedByte();
      } else if(var2 == 8) {
         this.field3334 = var1.readUnsignedByte();
      } else {
         int var3;
         int var4;
         if(var2 == 40) {
            var3 = var1.readUnsignedByte();
            this.field3326 = new short[var3];
            this.field3327 = new short[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field3326[var4] = (short)var1.readUnsignedShort();
               this.field3327[var4] = (short)var1.readUnsignedShort();
            }
         } else if(var2 == 41) {
            var3 = var1.readUnsignedByte();
            this.field3328 = new short[var3];
            this.field3322 = new short[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field3328[var4] = (short)var1.readUnsignedShort();
               this.field3322[var4] = (short)var1.readUnsignedShort();
            }
         }
      }

   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(IB)Leh;",
      garbageValue = "45"
   )
   public final Model method4404(int var1) {
      Model var2 = (Model)field3323.get((long)this.id);
      if(var2 == null) {
         ModelData var3 = ModelData.method2534(field3333, this.field3332, 0);
         if(var3 == null) {
            return null;
         }

         int var4;
         if(this.field3326 != null) {
            for(var4 = 0; var4 < this.field3326.length; ++var4) {
               var3.recolor(this.field3326[var4], this.field3327[var4]);
            }
         }

         if(this.field3328 != null) {
            for(var4 = 0; var4 < this.field3328.length; ++var4) {
               var3.method2495(this.field3328[var4], this.field3322[var4]);
            }
         }

         var2 = var3.light(this.field3324 + 64, this.field3334 + 850, -30, -50, -30);
         field3323.put(var2, (long)this.id);
      }

      Model var5;
      if(this.field3325 != -1 && var1 != -1) {
         var5 = NPCComposition.getAnimation(this.field3325).method4783(var2, var1);
      } else {
         var5 = var2.method2629(true);
      }

      if(this.field3330 != 128 || this.field3331 != 128) {
         var5.method2624(this.field3330, this.field3331, this.field3330);
      }

      if(this.field3329 != 0) {
         if(this.field3329 == 90) {
            var5.method2565();
         }

         if(this.field3329 == 180) {
            var5.method2565();
            var5.method2565();
         }

         if(this.field3329 == 270) {
            var5.method2565();
            var5.method2565();
            var5.method2565();
         }
      }

      return var5;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Lfz;I)V",
      garbageValue = "1345376364"
   )
   @Export("decode")
   void decode(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4403(var1, var2);
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(JLjava/lang/String;I)I",
      garbageValue = "-730124089"
   )
   static final int method4414(long var0, String var2) {
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

      var4.encryptRsa(class85.field1368, class85.field1372);
      var5.putByte(10);

      for(var7 = 0; var7 < 3; ++var7) {
         var5.putInt(var3.nextInt());
      }

      var5.putLong(var3.nextLong());
      var5.method3208(var3.nextLong());
      if(Client.field942 != null) {
         var5.putBytes(Client.field942, 0, Client.field942.length);
      } else {
         byte[] var19 = class251.method4530();
         var5.putBytes(var19, 0, var19.length);
      }

      var5.putLong(var3.nextLong());
      var5.encryptRsa(class85.field1368, class85.field1372);
      var7 = class86.getLength(var2);
      if(var7 % 8 != 0) {
         var7 += 8 - var7 % 8;
      }

      Buffer var8 = new Buffer(var7);
      var8.putString(var2);
      var8.offset = var7;
      var8.encryptXtea2(var6);
      Buffer var9 = new Buffer(var5.offset + var4.offset + var8.offset + 5);
      var9.putByte(2);
      var9.putByte(var4.offset);
      var9.putBytes(var4.payload, 0, var4.offset);
      var9.putByte(var5.offset);
      var9.putBytes(var5.payload, 0, var5.offset);
      var9.putShort(var8.offset);
      var9.putBytes(var8.payload, 0, var8.offset);
      String var10 = class96.method1880(var9.payload);

      try {
         URL var11 = new URL(class12.method71("services", false) + "m=accountappeal/login.ws");
         URLConnection var12 = var11.openConnection();
         var12.setDoInput(true);
         var12.setDoOutput(true);
         var12.setConnectTimeout(5000);
         OutputStreamWriter var13 = new OutputStreamWriter(var12.getOutputStream());
         var13.write("data2=" + class162.method3121(var10) + "&dest=" + class162.method3121("passwordchoice.ws"));
         var13.flush();
         InputStream var14 = var12.getInputStream();
         var9 = new Buffer(new byte[1000]);

         do {
            int var15 = var14.read(var9.payload, var9.offset, 1000 - var9.offset);
            if(var15 == -1) {
               var13.close();
               var14.close();
               String var18 = new String(var9.payload);
               if(var18.startsWith("OFFLINE")) {
                  return 4;
               } else if(var18.startsWith("WRONG")) {
                  return 7;
               } else if(var18.startsWith("RELOAD")) {
                  return 3;
               } else if(var18.startsWith("Not permitted for social network accounts.")) {
                  return 6;
               } else {
                  var9.decryptXtea(var6);

                  while(var9.offset > 0 && var9.payload[var9.offset - 1] == 0) {
                     --var9.offset;
                  }

                  var18 = new String(var9.payload, 0, var9.offset);
                  boolean var16;
                  if(var18 == null) {
                     var16 = false;
                  } else {
                     label84: {
                        try {
                           new URL(var18);
                        } catch (MalformedURLException var20) {
                           var16 = false;
                           break label84;
                        }

                        var16 = true;
                     }
                  }

                  if(var16) {
                     class155.method2999(var18, true, false);
                     return 2;
                  } else {
                     return 5;
                  }
               }
            }

            var9.offset += var15;
         } while(var9.offset < 1000);

         return 5;
      } catch (Throwable var21) {
         var21.printStackTrace();
         return 5;
      }
   }
}
