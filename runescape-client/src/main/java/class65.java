import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bc")
public class class65 {
   @ObfuscatedName("fu")
   @ObfuscatedGetter(
      intValue = 1722632099
   )
   static int field734;

   @ObfuscatedName("hw")
   @ObfuscatedSignature(
      signature = "(Lbl;IIBI)V",
      garbageValue = "-289962670"
   )
   static final void method1123(Player var0, int var1, int var2, byte var3) {
      int var4 = var0.pathX[0];
      int var5 = var0.pathY[0];
      int var6 = var0.getSize();
      if(var4 >= var6 && var4 < 104 - var6 && var5 >= var6 && var5 < 104 - var6) {
         if(var1 >= var6 && var1 < 104 - var6 && var2 >= var6 && var2 < 104 - var6) {
            int var9 = var0.getSize();
            Client.field1076.field2250 = var1;
            Client.field1076.field2249 = var2;
            Client.field1076.field2252 = 1;
            Client.field1076.field2248 = 1;
            class70 var10 = Client.field1076;
            int var11 = BoundingBox3DDrawMode.method51(var4, var5, var9, var10, Client.collisionMaps[var0.field802], true, Client.field1053, Client.field1078);
            if(var11 >= 1) {
               for(int var12 = 0; var12 < var11 - 1; ++var12) {
                  var0.method1192(Client.field1053[var12], Client.field1078[var12], var3);
               }

            }
         }
      }
   }
}
