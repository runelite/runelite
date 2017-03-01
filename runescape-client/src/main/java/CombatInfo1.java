import java.awt.FontMetrics;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("au")
@Implements("CombatInfo1")
public class CombatInfo1 extends Node {
   @ObfuscatedName("bf")
   static FontMetrics field663;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1973311945
   )
   @Export("healthRatio")
   int healthRatio;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -710076037
   )
   @Export("health")
   int health;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -1441488491
   )
   int field668;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -250829681
   )
   int field669;

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V",
      garbageValue = "-348268599"
   )
   @Export("addChatMessage")
   static void addChatMessage(int var0, String var1, String var2, String var3) {
      ChatLineBuffer var4 = (ChatLineBuffer)class47.chatLineMap.get(Integer.valueOf(var0));
      if(var4 == null) {
         var4 = new ChatLineBuffer();
         class47.chatLineMap.put(Integer.valueOf(var0), var4);
      }

      MessageNode var5 = var4.method994(var0, var1, var2, var3);
      class47.field943.method2412(var5, (long)var5.id);
      class47.field944.method2548(var5);
      Client.field481 = Client.field505;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "-1098590984"
   )
   void method643(int var1, int var2, int var3, int var4) {
      this.field669 = var1;
      this.healthRatio = var2;
      this.health = var3;
      this.field668 = var4;
   }

   CombatInfo1(int var1, int var2, int var3, int var4) {
      this.field669 = var1;
      this.healthRatio = var2;
      this.health = var3;
      this.field668 = var4;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lclass182;Lclass182;Lclass182;Lclass139;I)Z",
      garbageValue = "470268413"
   )
   public static boolean method647(class182 var0, class182 var1, class182 var2, class139 var3) {
      class138.field1918 = var0;
      class138.field1917 = var1;
      class138.field1916 = var2;
      class138.field1919 = var3;
      return true;
   }
}
