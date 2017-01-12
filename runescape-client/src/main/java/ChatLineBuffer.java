import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ao")
@Implements("ChatLineBuffer")
public class ChatLineBuffer {
   @ObfuscatedName("bu")
   static class184 field956;
   @ObfuscatedName("x")
   @Export("lines")
   MessageNode[] lines = new MessageNode[100];
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 2145376065
   )
   @Export("length")
   int length;
   @ObfuscatedName("nh")
   @ObfuscatedGetter(
      intValue = 689652137
   )
   static int field960;

   @ObfuscatedName("co")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1376424290"
   )
   static final void method874(int var0, int var1) {
      int var2 = class97.field1621.method3874("Choose Option");

      int var3;
      for(var3 = 0; var3 < Client.menuOptionCount; ++var3) {
         class208 var4 = class97.field1621;
         String var7;
         if(Client.menuTargets[var3].length() > 0) {
            var7 = Client.menuOptions[var3] + " " + Client.menuTargets[var3];
         } else {
            var7 = Client.menuOptions[var3];
         }

         int var6 = var4.method3874(var7);
         if(var6 > var2) {
            var2 = var6;
         }
      }

      var2 += 8;
      var3 = Client.menuOptionCount * 15 + 22;
      int var8 = var0 - var2 / 2;
      if(var2 + var8 > class0.field1) {
         var8 = class0.field1 - var2;
      }

      if(var8 < 0) {
         var8 = 0;
      }

      int var5 = var1;
      if(var3 + var1 > class65.field1099) {
         var5 = class65.field1099 - var3;
      }

      if(var5 < 0) {
         var5 = 0;
      }

      Client.isMenuOpen = true;
      class118.menuX = var8;
      Buffer.menuY = var5;
      class20.menuWidth = var2;
      class94.menuHeight = 22 + Client.menuOptionCount * 15;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;I)LMessageNode;",
      garbageValue = "-1963053609"
   )
   MessageNode method875(int var1, String var2, String var3, String var4) {
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
         var5.method2413();
         var5.method195(var1, var2, var4, var3);
      }

      this.lines[0] = var5;
      if(this.length < 100) {
         ++this.length;
      }

      return var5;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IB)LMessageNode;",
      garbageValue = "101"
   )
   MessageNode method876(int var1) {
      return var1 >= 0 && var1 < this.length?this.lines[var1]:null;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-740833162"
   )
   int method877() {
      return this.length;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1682753767"
   )
   public static void method879() {
      class115 var0 = class115.mouse;
      synchronized(class115.mouse) {
         class115.field1787 = class115.field1784;
         class115.field1788 = class115.field1795;
         class115.field1789 = class115.field1786;
         class115.field1794 = class115.field1790;
         class115.field1791 = class115.field1782;
         class115.field1796 = class115.field1792;
         class115.field1797 = class115.field1793;
         class115.field1790 = 0;
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1722088654"
   )
   public static void method886(int var0) {
      if(class138.field1900 != 0) {
         FrameMap.field1466 = var0;
      } else {
         class138.field1899.method2544(var0);
      }

   }
}
