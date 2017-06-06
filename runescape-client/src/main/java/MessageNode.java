import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bv")
@Implements("MessageNode")
public class MessageNode extends CacheableNode {
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1498618887
   )
   @Export("id")
   int id;
   @ObfuscatedName("h")
   public static IndexDataBase field876;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1259021023
   )
   @Export("type")
   int type;
   @ObfuscatedName("v")
   @Export("name")
   String name;
   @ObfuscatedName("b")
   @Export("sender")
   String sender;
   @ObfuscatedName("y")
   @Export("value")
   String value;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -234072481
   )
   @Export("tick")
   int tick;

   @ObfuscatedName("iq")
   @ObfuscatedSignature(
      signature = "([LWidget;IB)V",
      garbageValue = "-26"
   )
   static final void method1099(Widget[] var0, int var1) {
      for(int var2 = 0; var2 < var0.length; ++var2) {
         Widget var3 = var0[var2];
         if(var3 != null) {
            if(var3.type == 0) {
               if(var3.children != null) {
                  method1099(var3.children, var1);
               }

               WidgetNode var4 = (WidgetNode)Client.componentTable.method3520((long)var3.id);
               if(var4 != null) {
                  class158.method2978(var4.id, var1);
               }
            }

            class69 var5;
            if(var1 == 0 && var3.field2758 != null) {
               var5 = new class69();
               var5.field852 = var3;
               var5.field849 = var3.field2758;
               Friend.method1075(var5);
            }

            if(var1 == 1 && var3.field2759 != null) {
               if(var3.index >= 0) {
                  Widget var6 = WorldMapType3.method199(var3.id);
                  if(var6 == null || var6.children == null || var3.index >= var6.children.length || var6.children[var3.index] != var3) {
                     continue;
                  }
               }

               var5 = new class69();
               var5.field852 = var3;
               var5.field849 = var3.field2759;
               Friend.method1075(var5);
            }
         }
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;S)V",
      garbageValue = "18831"
   )
   void method1102(int var1, String var2, String var3, String var4) {
      this.id = method1105();
      this.tick = Client.gameCycle;
      this.type = var1;
      this.name = var2;
      this.sender = var3;
      this.value = var4;
   }

   MessageNode(int var1, String var2, String var3, String var4) {
      this.id = method1105();
      this.tick = Client.gameCycle;
      this.type = var1;
      this.name = var2;
      this.sender = var3;
      this.value = var4;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "78"
   )
   static int method1105() {
      return ++class98.field1533 - 1;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Lclass219;III)LScript;",
      garbageValue = "-1575170517"
   )
   static Script method1106(class219 var0, int var1, int var2) {
      int var3 = class146.method2895(var1, var0);
      Script var4 = class34.method476(var3, var0);
      if(var4 != null) {
         return var4;
      } else {
         var3 = class7.method22(var2, var0);
         var4 = class34.method476(var3, var0);
         return var4 != null?var4:null;
      }
   }

   @ObfuscatedName("fk")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1118174402"
   )
   static void method1107(int var0, int var1) {
      if(Client.field1165 != 0 && var0 != -1) {
         class59.method985(class4.indexTrack2, var0, 0, Client.field1165, false);
         Client.field1123 = true;
      }

   }

   @ObfuscatedName("hc")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "71"
   )
   static void method1108() {
      for(int var0 = 0; var0 < Client.menuOptionCount; ++var0) {
         if(class54.method775(Client.menuTypes[var0])) {
            if(var0 < Client.menuOptionCount - 1) {
               for(int var1 = var0; var1 < Client.menuOptionCount - 1; ++var1) {
                  Client.menuOptions[var1] = Client.menuOptions[var1 + 1];
                  Client.menuTargets[var1] = Client.menuTargets[var1 + 1];
                  Client.menuTypes[var1] = Client.menuTypes[var1 + 1];
                  Client.menuIdentifiers[var1] = Client.menuIdentifiers[var1 + 1];
                  Client.menuActionParams0[var1] = Client.menuActionParams0[var1 + 1];
                  Client.menuActionParams1[var1] = Client.menuActionParams1[var1 + 1];
               }
            }

            --Client.menuOptionCount;
         }
      }

   }
}
