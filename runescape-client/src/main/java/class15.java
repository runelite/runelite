import java.awt.Component;
import java.util.Comparator;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("v")
final class class15 implements Comparator {
   @ObfuscatedName("gj")
   static SpritePixels field300;
   @ObfuscatedName("lw")
   @ObfuscatedGetter(
      intValue = -94330985
   )
   static int field303;

   @ObfuscatedName("jr")
   @ObfuscatedSignature(
      signature = "(LWidget;I)I",
      garbageValue = "1273903805"
   )
   static int method92(Widget var0) {
      class198 var1 = (class198)Client.widgetFlags.method3425((long)var0.index + ((long)var0.id << 32));
      return var1 != null?var1.field2496:var0.field2650;
   }

   public int compare(Object var1, Object var2) {
      return this.method100((class14)var1, (class14)var2);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Lclass14;Lclass14;I)I",
      garbageValue = "-1966408094"
   )
   int method100(class14 var1, class14 var2) {
      return var1.field292.totalQuantity < var2.field292.totalQuantity?-1:(var1.field292.totalQuantity == var2.field292.totalQuantity?0:1);
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;I)V",
      garbageValue = "-1492866595"
   )
   static void method102(Component var0) {
      var0.setFocusTraversalKeysEnabled(false);
      var0.addKeyListener(class50.keyboard);
      var0.addFocusListener(class50.keyboard);
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;B)V",
      garbageValue = "-105"
   )
   @Export("addChatMessage")
   static void addChatMessage(int var0, String var1, String var2, String var3) {
      ChatLineBuffer var4 = (ChatLineBuffer)class98.chatLineMap.get(Integer.valueOf(var0));
      if(var4 == null) {
         var4 = new ChatLineBuffer();
         class98.chatLineMap.put(Integer.valueOf(var0), var4);
      }

      MessageNode var5 = var4.method1771(var0, var1, var2, var3);
      class98.field1517.method3394(var5, (long)var5.id);
      class98.field1523.method3556(var5);
      Client.field1098 = Client.field1091;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(II)Ljava/lang/String;",
      garbageValue = "2002001395"
   )
   static String method105(int var0) {
      return "<col=" + Integer.toHexString(var0) + ">";
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-543378679"
   )
   public static int method106(int var0) {
      return var0 >> 17 & 7;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)[Lclass231;",
      garbageValue = "1775373854"
   )
   public static class231[] method107() {
      return new class231[]{class231.field3190, class231.field3198, class231.field3192, class231.field3191};
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)[Lclass276;",
      garbageValue = "607258951"
   )
   static class276[] method109() {
      return new class276[]{class276.field3734, class276.field3732, class276.field3733};
   }
}
