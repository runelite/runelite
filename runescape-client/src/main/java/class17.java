import java.io.File;
import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("u")
@Implements("Friend")
public class class17 {
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -897442165
   )
   @Export("rank")
   int field237;
   @ObfuscatedName("i")
   @Export("previousName")
   String field238;
   @ObfuscatedName("t")
   @Export("name")
   String field239;
   @ObfuscatedName("z")
   boolean field241;
   @ObfuscatedName("r")
   boolean field242;
   @ObfuscatedName("na")
   static class56 field247;
   @ObfuscatedName("ew")
   static class80[] field248;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1708971589
   )
   @Export("world")
   int field249;

   @ObfuscatedName("dn")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;II)V",
      garbageValue = "-1039386513"
   )
   static final void method166(String var0, int var1) {
      client.field325.method2733(3);
      client.field325.method2453(class102.method2237(var0) + 1);
      client.field325.method2586(var0);
      client.field325.method2594(var1);
   }

   @ObfuscatedName("et")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZI)Ljava/lang/String;",
      garbageValue = "1"
   )
   static String method167(String var0, boolean var1) {
      String var2 = "https://";
      if(client.field384 == 1) {
         var0 = var0 + "-wtrc";
      } else if(client.field384 == 2) {
         var0 = var0 + "-wtqa";
      } else if(client.field384 == 3) {
         var0 = var0 + "-wtwip";
      } else if(client.field384 == 5) {
         var0 = var0 + "-wti";
      } else if(client.field384 == 4) {
         var0 = "local";
      }

      String var3 = "";
      if(null != client.field289) {
         var3 = "/p=" + client.field289;
      }

      String var4 = "runescape.com";
      return var2 + var0 + "." + var4 + "/l=" + client.field288 + "/a=" + class7.field131 + var3 + "/";
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Lclass25;Lclass25;IZI)I",
      garbageValue = "-2129218772"
   )
   static int method168(class25 var0, class25 var1, int var2, boolean var3) {
      if(var2 == 1) {
         int var4 = var0.field639;
         int var5 = var1.field639;
         if(!var3) {
            if(var4 == -1) {
               var4 = 2001;
            }

            if(var5 == -1) {
               var5 = 2001;
            }
         }

         return var4 - var5;
      } else {
         return var2 == 2?var0.field642 - var1.field642:(var2 == 3?(var0.field633.equals("-")?(var1.field633.equals("-")?0:(var3?-1:1)):(var1.field633.equals("-")?(var3?1:-1):var0.field633.compareTo(var1.field633))):(var2 == 4?(var0.method582()?(var1.method582()?0:1):(var1.method582()?-1:0)):(var2 == 5?(var0.method580()?(var1.method580()?0:1):(var1.method580()?-1:0)):(var2 == 6?(var0.method581()?(var1.method581()?0:1):(var1.method581()?-1:0)):(var2 == 7?(var0.method579()?(var1.method579()?0:1):(var1.method579()?-1:0)):var0.field637 - var1.field637)))));
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(II)Lclass39;",
      garbageValue = "-1492261259"
   )
   @Export("getNpcDefinition")
   public static class39 method169(int var0) {
      class39 var1 = (class39)class39.field879.method3716((long)var0);
      if(null != var1) {
         return var1;
      } else {
         byte[] var2 = class39.field905.method3221(9, var0);
         var1 = new class39();
         var1.field911 = var0;
         if(var2 != null) {
            var1.method748(new class119(var2));
         }

         var1.method782();
         class39.field879.method3724(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;ZI)Lclass227;",
      garbageValue = "-59863568"
   )
   public static class227 method170(String var0, String var1, boolean var2) {
      File var3 = new File(class149.field2270, "preferences" + var0 + ".dat");
      if(var3.exists()) {
         try {
            class227 var10 = new class227(var3, "rw", 10000L);
            return var10;
         } catch (IOException var9) {
            ;
         }
      }

      String var4 = "";
      if(class111.field1957 == 33) {
         var4 = "_rc";
      } else if(class111.field1957 == 34) {
         var4 = "_wip";
      }

      File var5 = new File(class149.field2272, "jagex_" + var1 + "_preferences" + var0 + var4 + ".dat");
      class227 var6;
      if(!var2 && var5.exists()) {
         try {
            var6 = new class227(var5, "rw", 10000L);
            return var6;
         } catch (IOException var8) {
            ;
         }
      }

      try {
         var6 = new class227(var3, "rw", 10000L);
         return var6;
      } catch (IOException var7) {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "([BIIII[Lclass108;I)V",
      garbageValue = "163143338"
   )
   static final void method171(byte[] var0, int var1, int var2, int var3, int var4, class108[] var5) {
      int var7;
      int var8;
      for(int var6 = 0; var6 < 4; ++var6) {
         for(var7 = 0; var7 < 64; ++var7) {
            for(var8 = 0; var8 < 64; ++var8) {
               if(var1 + var7 > 0 && var7 + var1 < 103 && var2 + var8 > 0 && var2 + var8 < 103) {
                  var5[var6].field1906[var1 + var7][var2 + var8] &= -16777217;
               }
            }
         }
      }

      class119 var10 = new class119(var0);

      for(var7 = 0; var7 < 4; ++var7) {
         for(var8 = 0; var8 < 64; ++var8) {
            for(int var9 = 0; var9 < 64; ++var9) {
               class102.method2238(var10, var7, var1 + var8, var2 + var9, var3, var4, 0);
            }
         }
      }

   }
}
