import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ao")
@Implements("NPC")
public final class class34 extends class37 {
   @ObfuscatedName("a")
   @Export("composition")
   class39 field785;
   @ObfuscatedName("es")
   static class78[] field787;

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(IIZI)V",
      garbageValue = "-1207165651"
   )
   final void method717(int var1, int var2, boolean var3) {
      if(super.field869 != -1 && class134.method2875(super.field869).field992 == 1) {
         super.field869 = -1;
      }

      if(!var3) {
         int var4 = var1 - super.field866[0];
         int var5 = var2 - super.field867[0];
         if(var4 >= -8 && var4 <= 8 && var5 >= -8 && var5 <= 8) {
            if(super.field865 < 9) {
               ++super.field865;
            }

            for(int var6 = super.field865; var6 > 0; --var6) {
               super.field866[var6] = super.field866[var6 - 1];
               super.field867[var6] = super.field867[var6 - 1];
               super.field831[var6] = super.field831[var6 - 1];
            }

            super.field866[0] = var1;
            super.field867[0] = var2;
            super.field831[0] = 1;
            return;
         }
      }

      super.field865 = 0;
      super.field861 = 0;
      super.field848 = 0;
      super.field866[0] = var1;
      super.field867[0] = var2;
      super.field870 = super.field866[0] * 128 + super.field816 * 64;
      super.field813 = super.field816 * 64 + super.field867[0] * 128;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(IBI)V",
      garbageValue = "-556682443"
   )
   final void method718(int var1, byte var2) {
      int var3 = super.field866[0];
      int var4 = super.field867[0];
      if(var1 == 0) {
         --var3;
         ++var4;
      }

      if(var1 == 1) {
         ++var4;
      }

      if(2 == var1) {
         ++var3;
         ++var4;
      }

      if(3 == var1) {
         --var3;
      }

      if(var1 == 4) {
         ++var3;
      }

      if(var1 == 5) {
         --var3;
         --var4;
      }

      if(6 == var1) {
         --var4;
      }

      if(7 == var1) {
         ++var3;
         --var4;
      }

      if(super.field869 != -1 && class134.method2875(super.field869).field992 == 1) {
         super.field869 = -1;
      }

      if(super.field865 < 9) {
         ++super.field865;
      }

      for(int var5 = super.field865; var5 > 0; --var5) {
         super.field866[var5] = super.field866[var5 - 1];
         super.field867[var5] = super.field867[var5 - 1];
         super.field831[var5] = super.field831[var5 - 1];
      }

      super.field866[0] = var3;
      super.field867[0] = var4;
      super.field831[0] = var2;
   }

   @ObfuscatedName("g")
   final boolean vmethod755() {
      return this.field785 != null;
   }

   @ObfuscatedName("f")
   protected final class104 vmethod1919() {
      if(null == this.field785) {
         return null;
      } else {
         class42 var1 = -1 != super.field869 && super.field846 == 0?class134.method2875(super.field869):null;
         class42 var2 = -1 != super.field840 && (super.field840 != super.field817 || null == var1)?class134.method2875(super.field840):null;
         class104 var3 = this.field785.method772(var1, super.field844, var2, super.field841);
         if(null == var3) {
            return null;
         } else {
            var3.method2305();
            super.field845 = var3.field1448;
            if(-1 != super.field859 && super.field849 != -1) {
               class104 var4 = class24.method595(super.field859).method909(super.field849);
               if(null != var4) {
                  var4.method2320(0, -super.field852, 0);
                  class104[] var5 = new class104[]{var3, var4};
                  var3 = new class104(var5, 2);
               }
            }

            if(this.field785.field881 == 1) {
               var3.field1812 = true;
            }

            return var3;
         }
      }
   }

   @ObfuscatedName("r")
   public static int method732(byte[] var0, int var1) {
      return class52.method1093(var0, 0, var1);
   }

   @ObfuscatedName("a")
   static long method733() {
      try {
         URL var0 = new URL(class93.method2183("services", false) + "m=accountappeal/login.ws");
         URLConnection var1 = var0.openConnection();
         var1.setRequestProperty("connection", "close");
         var1.setDoInput(true);
         var1.setDoOutput(true);
         var1.setConnectTimeout(5000);
         OutputStreamWriter var2 = new OutputStreamWriter(var1.getOutputStream());
         var2.write("data1=req");
         var2.flush();
         InputStream var3 = var1.getInputStream();
         class118 var4 = new class118(new byte[1000]);

         do {
            int var5 = var3.read(var4.field1980, var4.field1979, 1000 - var4.field1979);
            if(var5 == -1) {
               var4.field1979 = 0;
               long var8 = var4.method2518();
               return var8;
            }

            var4.field1979 += var5;
         } while(var4.field1979 < 1000);

         return 0L;
      } catch (Exception var7) {
         return 0L;
      }
   }
}
