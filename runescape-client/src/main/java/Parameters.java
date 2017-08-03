import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Random;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jm")
@Implements("Parameters")
public class Parameters {
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Ljm;"
   )
   public static final Parameters field3699;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Ljm;"
   )
   public static final Parameters field3700;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Ljm;"
   )
   public static final Parameters field3705;
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "Ljm;"
   )
   public static final Parameters field3702;
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "Ljm;"
   )
   public static final Parameters field3708;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Ljm;"
   )
   public static final Parameters field3701;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Ljm;"
   )
   public static final Parameters field3707;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Ljm;"
   )
   public static final Parameters field3703;
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Ljm;"
   )
   public static final Parameters field3709;
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Ljm;"
   )
   public static final Parameters field3713;
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Ljm;"
   )
   public static final Parameters field3704;
   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "Ljm;"
   )
   public static final Parameters field3706;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Ljm;"
   )
   public static final Parameters field3710;
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Ljm;"
   )
   public static final Parameters field3712;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Ljm;"
   )
   public static final Parameters field3711;
   @ObfuscatedName("b")
   @Export("key")
   public final String key;

   static {
      field3699 = new Parameters("5", "5");
      field3700 = new Parameters("3", "3");
      field3701 = new Parameters("11", "11");
      field3702 = new Parameters("2", "2");
      field3703 = new Parameters("15", "15");
      field3704 = new Parameters("12", "12");
      field3708 = new Parameters("8", "8");
      field3709 = new Parameters("14", "14");
      field3707 = new Parameters("1", "1");
      field3713 = new Parameters("6", "6");
      field3710 = new Parameters("13", "13");
      field3705 = new Parameters("10", "10");
      field3711 = new Parameters("4", "4");
      field3712 = new Parameters("9", "9");
      field3706 = new Parameters("7", "7");
   }

   Parameters(String var1, String var2) {
      this.key = var2;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(JLjava/lang/String;I)I",
      garbageValue = "-1502157341"
   )
   static final int method4905(long var0, String var2) {
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

      var4.encryptRsa(class87.field1347, class87.field1348);
      var5.putByte(10);

      for(var7 = 0; var7 < 3; ++var7) {
         var5.putInt(var3.nextInt());
      }

      var5.putLong(var3.nextLong());
      var5.method3266(var3.nextLong());
      WidgetNode.method1111(var5);
      var5.putLong(var3.nextLong());
      var5.encryptRsa(class87.field1347, class87.field1348);
      var7 = VertexNormal.getLength(var2);
      if(var7 % 8 != 0) {
         var7 += 8 - var7 % 8;
      }

      Buffer var8 = new Buffer(var7);
      var8.putString(var2);
      var8.offset = var7;
      var8.encryptXtea2(var6);
      Buffer var9 = new Buffer(var8.offset + var5.offset + var4.offset + 5);
      var9.putByte(2);
      var9.putByte(var4.offset);
      var9.putBytes(var4.payload, 0, var4.offset);
      var9.putByte(var5.offset);
      var9.putBytes(var5.payload, 0, var5.offset);
      var9.putShort(var8.offset);
      var9.putBytes(var8.payload, 0, var8.offset);
      String var10 = IndexData.method4210(var9.payload);

      try {
         URL var11 = new URL(class71.method1131("services", false) + "m=accountappeal/login.ws");
         URLConnection var12 = var11.openConnection();
         var12.setDoInput(true);
         var12.setDoOutput(true);
         var12.setConnectTimeout(5000);
         OutputStreamWriter var13 = new OutputStreamWriter(var12.getOutputStream());
         var13.write("data2=" + class73.method1144(var10) + "&dest=" + class73.method1144("passwordchoice.ws"));
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
                     label80: {
                        try {
                           new URL(var18);
                        } catch (MalformedURLException var19) {
                           var16 = false;
                           break label80;
                        }

                        var16 = true;
                     }
                  }

                  if(var16) {
                     DynamicObject.method1871(var18, true, false);
                     return 2;
                  } else {
                     return 5;
                  }
               }
            }

            var9.offset += var15;
         } while(var9.offset < 1000);

         return 5;
      } catch (Throwable var20) {
         var20.printStackTrace();
         return 5;
      }
   }
}
