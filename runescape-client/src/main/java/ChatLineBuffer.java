import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ad")
@Implements("ChatLineBuffer")
public class ChatLineBuffer {
   @ObfuscatedName("q")
   @Export("lines")
   MessageNode[] lines = new MessageNode[100];
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 329656803
   )
   @Export("length")
   int length;
   @ObfuscatedName("np")
   @ObfuscatedGetter(
      intValue = -1267741407
   )
   static int field688;
   @ObfuscatedName("m")
   static int[] field693;

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;B)LMessageNode;",
      garbageValue = "9"
   )
   MessageNode method662(int var1, String var2, String var3, String var4) {
      MessageNode var5 = this.lines[99];

      for(int var6 = this.length; var6 > 0; --var6) {
         if(var6 != 100) {
            this.lines[var6] = this.lines[var6 - 1];
         }
      }

      if(var5 == null) {
         var5 = new MessageNode(var1, var2, var4, var3);
      } else {
         var5.unlink();
         var5.method3932();
         var5.method757(var1, var2, var4, var3);
      }

      this.lines[0] = var5;
      if(this.length < 100) {
         ++this.length;
      }

      return var5;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(II)LMessageNode;",
      garbageValue = "601759868"
   )
   MessageNode method663(int var1) {
      return var1 >= 0 && var1 < this.length?this.lines[var1]:null;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1250603674"
   )
   int method664() {
      return this.length;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(II)LKitDefinition;",
      garbageValue = "524723469"
   )
   @Export("getKitDefinition")
   public static KitDefinition getKitDefinition(int var0) {
      KitDefinition var1 = (KitDefinition)KitDefinition.field1052.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = KitDefinition.field1054.method3305(3, var0);
         var1 = new KitDefinition();
         if(var2 != null) {
            var1.method952(new Buffer(var2));
         }

         KitDefinition.field1052.put(var1, (long)var0);
         return var1;
      }
   }
}
