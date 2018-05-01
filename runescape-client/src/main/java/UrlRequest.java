import java.net.URL;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ek")
@Implements("UrlRequest")
public class UrlRequest {
   @ObfuscatedName("gq")
   @ObfuscatedGetter(
      intValue = -537130557
   )
   @Export("cameraX")
   static int cameraX;
   @ObfuscatedName("g")
   @Export("url")
   final URL url;
   @ObfuscatedName("e")
   @Export("isDone0")
   volatile boolean isDone0;
   @ObfuscatedName("b")
   @Export("response0")
   volatile byte[] response0;

   UrlRequest(URL var1) {
      this.url = var1;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-751816330"
   )
   @Export("isDone")
   public boolean isDone() {
      return this.isDone0;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)[B",
      garbageValue = "1288378637"
   )
   @Export("getResponse")
   public byte[] getResponse() {
      return this.response0;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IB)Ljq;",
      garbageValue = "57"
   )
   public static class279 method3173(int var0) {
      class279 var1 = (class279)class279.field3553.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class279.field3554.getConfigData(34, var0);
         var1 = new class279();
         if(var2 != null) {
            var1.method5020(new Buffer(var2));
         }

         var1.method5007();
         class279.field3553.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1955067957"
   )
   static void method3183() {
      if(class90.Login_isUsernameRemembered && class90.username != null && class90.username.length() > 0) {
         class90.field1363 = 1;
      } else {
         class90.field1363 = 0;
      }

   }

   @ObfuscatedName("jr")
   @ObfuscatedSignature(
      signature = "(Liz;I)Z",
      garbageValue = "-2145735007"
   )
   static final boolean method3182(Widget var0) {
      if(var0.tableActions == null) {
         return false;
      } else {
         for(int var1 = 0; var1 < var0.tableActions.length; ++var1) {
            int var2 = MapIconReference.method758(var0, var1);
            int var3 = var0.field2935[var1];
            if(var0.tableActions[var1] == 2) {
               if(var2 >= var3) {
                  return false;
               }
            } else if(var0.tableActions[var1] == 3) {
               if(var2 <= var3) {
                  return false;
               }
            } else if(var0.tableActions[var1] == 4) {
               if(var3 == var2) {
                  return false;
               }
            } else if(var3 != var2) {
               return false;
            }
         }

         return true;
      }
   }
}
