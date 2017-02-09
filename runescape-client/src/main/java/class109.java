import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dd")
public abstract class class109 {
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1203637754"
   )
   abstract void vmethod2039();

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(IIB)I",
      garbageValue = "96"
   )
   abstract int vmethod2040(int var1, int var2);

   @ObfuscatedName("cu")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;I)V",
      garbageValue = "787650481"
   )
   static void method2045(int var0, String var1) {
      int var2 = class45.field901;
      int[] var3 = class45.field902;
      boolean var4 = false;

      for(int var5 = 0; var5 < var2; ++var5) {
         Player var6 = Client.cachedPlayers[var3[var5]];
         if(null != var6 && var6 != VertexNormal.localPlayer && var6.name != null && var6.name.equalsIgnoreCase(var1)) {
            if(var0 == 1) {
               Client.field321.method3195(174);
               Client.field321.method2961(var3[var5]);
               Client.field321.method2951(0);
            } else if(var0 == 4) {
               Client.field321.method3195(36);
               Client.field321.method2952(0);
               Client.field321.method2960(var3[var5]);
            } else if(var0 == 6) {
               Client.field321.method3195(147);
               Client.field321.method3094(var3[var5]);
               Client.field321.method2912(0);
            } else if(var0 == 7) {
               Client.field321.method3195(48);
               Client.field321.method2960(var3[var5]);
               Client.field321.method2952(0);
            }

            var4 = true;
            break;
         }
      }

      if(!var4) {
         ChatLineBuffer.sendGameMessage(4, "", "Unable to find " + var1);
      }

   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(II)Lclass187;",
      garbageValue = "-1035994522"
   )
   public static class187 method2046(int var0) {
      class187 var1 = (class187)class187.field2756.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class187.field2759.getConfigData(16, var0);
         var1 = new class187();
         if(null != var2) {
            var1.method3420(new Buffer(var2));
         }

         class187.field2756.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1119540616"
   )
   public static void method2047() {
      try {
         class104.field1694.method1388();

         for(int var0 = 0; var0 < WidgetNode.field177; ++var0) {
            XItemContainer.field120[var0].method1388();
         }

         class104.field1695.method1388();
         class104.field1693.method1388();
      } catch (Exception var2) {
         ;
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lclass68;B)V",
      garbageValue = "0"
   )
   static final void method2048(class68 var0) {
      var0.field1142 = false;
      if(null != var0.field1145) {
         var0.field1145.field1176 = 0;
      }

      for(class68 var1 = var0.vmethod2708(); null != var1; var1 = var0.vmethod2687()) {
         method2048(var1);
      }

   }
}
