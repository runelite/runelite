import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("co")
@Implements("ChatLineBuffer")
public class ChatLineBuffer {
   @ObfuscatedName("qd")
   static short[] field1454;
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lks;"
   )
   static IndexedSprite field1453;
   @ObfuscatedName("cf")
   @ObfuscatedSignature(
      signature = "Liu;"
   )
   @Export("indexSoundEffects")
   static IndexData indexSoundEffects;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "[Lbn;"
   )
   @Export("lines")
   MessageNode[] lines;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 714192897
   )
   @Export("length")
   int length;

   ChatLineBuffer() {
      this.lines = new MessageNode[100];
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Lbn;",
      garbageValue = "-1129286777"
   )
   @Export("addMessage")
   MessageNode addMessage(int var1, String var2, String var3, String var4) {
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
         var5.unlinkDual();
         var5.setMessage(var1, var2, var4, var3);
      }

      this.lines[0] = var5;
      if(this.length < 100) {
         ++this.length;
      }

      return var5;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(II)Lbn;",
      garbageValue = "-1597872251"
   )
   MessageNode method1847(int var1) {
      return var1 >= 0 && var1 < this.length?this.lines[var1]:null;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "2016403088"
   )
   int method1846() {
      return this.length;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(B)J",
      garbageValue = "-74"
   )
   @Export("currentTimeMs")
   public static synchronized long currentTimeMs() {
      long var0 = System.currentTimeMillis();
      if(var0 < class182.field2505) {
         class17.field289 += class182.field2505 - var0;
      }

      class182.field2505 = var0;
      return var0 + class17.field289;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Lgu;ILjava/lang/String;I)Ljava/lang/String;",
      garbageValue = "-2108222027"
   )
   static String method1852(IterableHashTable var0, int var1, String var2) {
      if(var0 == null) {
         return var2;
      } else {
         ObjectNode var3 = (ObjectNode)var0.get((long)var1);
         return var3 == null?var2:(String)var3.value;
      }
   }
}
