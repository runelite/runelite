import net.runelite.mapping.Export;
import net.runelite.mapping.Hook;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bv")
@Implements("MessageNode")
public class MessageNode extends CacheableNode {
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 547236239
   )
   @Export("id")
   int id;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -319814821
   )
   @Export("tick")
   int tick;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1875201887
   )
   @Export("type")
   int type;
   @ObfuscatedName("r")
   @Export("name")
   String name;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lko;"
   )
   Name field813;
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "Lkj;"
   )
   class303 field814;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lkj;"
   )
   class303 field819;
   @ObfuscatedName("s")
   @Export("sender")
   String sender;
   @ObfuscatedName("p")
   @Export("value")
   String value;

   @Hook(
      value = "setMessage",
      end = true
   )
   MessageNode(int var1, String var2, String var3, String var4) {
      this.field814 = class303.field3844;
      this.field819 = class303.field3844;
      this.id = class5.method17();
      this.tick = Client.gameCycle;
      this.type = var1;
      this.name = var2;
      this.method1109();
      this.sender = var3;
      this.value = var4;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V",
      garbageValue = "632753158"
   )
   @Export("setMessage")
   @Hook(
      value = "setMessage",
      end = true
   )
   void setMessage(int var1, String var2, String var3, String var4) {
      this.id = class5.method17();
      this.tick = Client.gameCycle;
      this.type = var1;
      this.name = var2;
      this.method1109();
      this.sender = var3;
      this.value = var4;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "20"
   )
   void method1103() {
      this.field814 = class303.field3844;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-835352378"
   )
   final boolean method1104() {
      if(this.field814 == class303.field3844) {
         this.method1101();
      }

      return this.field814 == class303.field3842;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1885480014"
   )
   void method1101() {
      this.field814 = ContextMenuRow.friendManager.field1235.isMember(this.field813)?class303.field3842:class303.field3843;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1976689329"
   )
   void method1123() {
      this.field819 = class303.field3844;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "217151411"
   )
   final boolean method1127() {
      if(this.field819 == class303.field3844) {
         this.method1106();
      }

      return this.field819 == class303.field3842;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1765854956"
   )
   void method1106() {
      this.field819 = ContextMenuRow.friendManager.field1233.isMember(this.field813)?class303.field3842:class303.field3843;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1458509374"
   )
   final void method1109() {
      if(this.name != null) {
         this.field813 = new Name(class44.method625(this.name), class21.loginType);
      } else {
         this.field813 = null;
      }

   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "15263"
   )
   static void method1130() {
      FileOnDisk var0 = null;

      try {
         var0 = Item.getPreferencesFile("", class150.field2118.name, true);
         Buffer var1 = class55.preferences.serialize();
         var0.write(var1.payload, 0, var1.offset);
      } catch (Exception var3) {
         ;
      }

      try {
         if(var0 != null) {
            var0.closeSync(true);
         }
      } catch (Exception var2) {
         ;
      }

   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "415"
   )
   static final void method1111() {
      class243.method4617("Your friend list is full. Max of 200 for free users, and 400 for members");
   }

   @ObfuscatedName("fk")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "-58"
   )
   static boolean method1132() {
      return (Client.field988 & 1) != 0;
   }

   @ObfuscatedName("iu")
   @ObfuscatedSignature(
      signature = "([Liw;IIIZB)V",
      garbageValue = "1"
   )
   static void method1128(Widget[] var0, int var1, int var2, int var3, boolean var4) {
      for(int var5 = 0; var5 < var0.length; ++var5) {
         Widget var6 = var0[var5];
         if(var6 != null && var6.parentId == var1) {
            Huffman.method3509(var6, var2, var3, var4);
            method1108(var6, var2, var3);
            if(var6.scrollX > var6.scrollWidth - var6.width) {
               var6.scrollX = var6.scrollWidth - var6.width;
            }

            if(var6.scrollX < 0) {
               var6.scrollX = 0;
            }

            if(var6.scrollY > var6.scrollHeight - var6.height) {
               var6.scrollY = var6.scrollHeight - var6.height;
            }

            if(var6.scrollY < 0) {
               var6.scrollY = 0;
            }

            if(var6.type == 0) {
               class183.method3484(var0, var6, var4);
            }
         }
      }

   }

   @ObfuscatedName("ik")
   @ObfuscatedSignature(
      signature = "(Liw;III)V",
      garbageValue = "1149242976"
   )
   static void method1108(Widget var0, int var1, int var2) {
      if(var0.dynamicX == 0) {
         var0.relativeX = var0.originalX;
      } else if(var0.dynamicX == 1) {
         var0.relativeX = var0.originalX + (var1 - var0.width) / 2;
      } else if(var0.dynamicX == 2) {
         var0.relativeX = var1 - var0.width - var0.originalX;
      } else if(var0.dynamicX == 3) {
         var0.relativeX = var0.originalX * var1 >> 14;
      } else if(var0.dynamicX == 4) {
         var0.relativeX = (var1 - var0.width) / 2 + (var0.originalX * var1 >> 14);
      } else {
         var0.relativeX = var1 - var0.width - (var0.originalX * var1 >> 14);
      }

      if(var0.dynamicY == 0) {
         var0.relativeY = var0.originalY;
      } else if(var0.dynamicY == 1) {
         var0.relativeY = (var2 - var0.height) / 2 + var0.originalY;
      } else if(var0.dynamicY == 2) {
         var0.relativeY = var2 - var0.height - var0.originalY;
      } else if(var0.dynamicY == 3) {
         var0.relativeY = var2 * var0.originalY >> 14;
      } else if(var0.dynamicY == 4) {
         var0.relativeY = (var2 - var0.height) / 2 + (var2 * var0.originalY >> 14);
      } else {
         var0.relativeY = var2 - var0.height - (var2 * var0.originalY >> 14);
      }

   }
}
