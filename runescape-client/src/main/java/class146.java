import java.util.zip.Inflater;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ej")
public class class146 {
   @ObfuscatedName("s")
   Inflater field2028;
   @ObfuscatedName("z")
   static int[] field2031;

   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1000000"
   )
   class146(int var1, int var2, int var3) {
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(LBuffer;[BI)V",
      garbageValue = "-890907108"
   )
   public void method2656(Buffer var1, byte[] var2) {
      if(var1.payload[var1.offset] == 31 && var1.payload[var1.offset + 1] == -117) {
         if(this.field2028 == null) {
            this.field2028 = new Inflater(true);
         }

         try {
            this.field2028.setInput(var1.payload, var1.offset + 10, var1.payload.length - (8 + var1.offset + 10));
            this.field2028.inflate(var2);
         } catch (Exception var4) {
            this.field2028.reset();
            throw new RuntimeException("");
         }

         this.field2028.reset();
      } else {
         throw new RuntimeException("");
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "81"
   )
   public static void method2658() {
      KitDefinition.field2830.reset();
   }

   @ObfuscatedName("eq")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZI)Ljava/lang/String;",
      garbageValue = "-270233107"
   )
   static String method2660(String var0, boolean var1) {
      String var2 = var1?"https://":"http://";
      if(Client.field297 == 1) {
         var0 = var0 + "-wtrc";
      } else if(Client.field297 == 2) {
         var0 = var0 + "-wtqa";
      } else if(Client.field297 == 3) {
         var0 = var0 + "-wtwip";
      } else if(Client.field297 == 5) {
         var0 = var0 + "-wti";
      } else if(Client.field297 == 4) {
         var0 = "local";
      }

      String var3 = "";
      if(null != class155.field2116) {
         var3 = "/p=" + class155.field2116;
      }

      String var4 = "runescape.com";
      return var2 + var0 + "." + var4 + "/l=" + Client.field300 + "/a=" + class65.field1107 + var3 + "/";
   }

   public class146() {
      this(-1, 1000000, 1000000);
   }
}
