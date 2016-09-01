import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ab")
@Implements("MessageNode")
public class MessageNode extends CacheableNode {
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 936708005
   )
   @Export("id")
   int id;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1438024347
   )
   @Export("type")
   int type;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1371373267
   )
   @Export("tick")
   int tick;
   @ObfuscatedName("z")
   @Export("name")
   String name;
   @ObfuscatedName("b")
   @Export("value")
   String value;
   @ObfuscatedName("i")
   @Export("sender")
   String sender;

   MessageNode(int var1, String var2, String var3, String var4) {
      int var5 = ++class11.field166 - 1;
      this.id = var5;
      this.tick = Client.gameCycle;
      this.type = var1;
      this.name = var2;
      this.sender = var3;
      this.value = var4;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;B)V",
      garbageValue = "36"
   )
   void method732(int var1, String var2, String var3, String var4) {
      int var5 = ++class11.field166 - 1;
      this.id = var5;
      this.tick = Client.gameCycle;
      this.type = var1;
      this.name = var2;
      this.sender = var3;
      this.value = var4;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(II)LItemComposition;",
      garbageValue = "-1299601286"
   )
   @Export("getItemDefinition")
   public static ItemComposition getItemDefinition(int var0) {
      ItemComposition var1 = (ItemComposition)ItemComposition.field1159.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = ItemComposition.field1198.method3290(10, var0);
         var1 = new ItemComposition();
         var1.id = var0;
         if(null != var2) {
            var1.loadBuffer(new Buffer(var2));
         }

         var1.method1099();
         if(var1.field1195 != -1) {
            var1.method1102(getItemDefinition(var1.field1195), getItemDefinition(var1.note));
         }

         if(var1.field1204 != -1) {
            var1.method1103(getItemDefinition(var1.field1204), getItemDefinition(var1.field1154));
         }

         if(var1.field1206 != -1) {
            var1.method1155(getItemDefinition(var1.field1206), getItemDefinition(var1.field1205));
         }

         if(!ItemComposition.isMembersWorld && var1.isMembers) {
            var1.name = "Members object";
            var1.field1202 = false;
            var1.groundActions = null;
            var1.inventoryActions = null;
            var1.field1200 = 0;
         }

         ItemComposition.field1159.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-2100907419"
   )
   static void method735(int var0) {
      if(var0 != -1) {
         if(class175.method3419(var0)) {
            Widget[] var1 = Widget.widgets[var0];

            for(int var2 = 0; var2 < var1.length; ++var2) {
               Widget var3 = var1[var2];
               if(var3.field2891 != null) {
                  class0 var4 = new class0();
                  var4.field7 = var3;
                  var4.field8 = var3.field2891;
                  class158.method3201(var4, 2000000);
               }
            }

         }
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lclass170;Lclass170;I)V",
      garbageValue = "426320443"
   )
   public static void method737(class170 var0, class170 var1) {
      class49.field1078 = var0;
      class49.field1072 = var1;
   }
}
