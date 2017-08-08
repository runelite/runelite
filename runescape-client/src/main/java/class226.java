import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hr")
public class class226 {
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(II)Ljh;",
      garbageValue = "-1409655293"
   )
   public static Overlay method4083(int var0) {
      Overlay var1 = (Overlay)Overlay.overlays.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = Overlay.overlay_ref.getConfigData(4, var0);
         var1 = new Overlay();
         if(var2 != null) {
            var1.decode(new Buffer(var2), var0);
         }

         var1.post();
         Overlay.overlays.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(ILfq;Lid;I)V",
      garbageValue = "1959861299"
   )
   static void method4084(int var0, IndexFile var1, IndexData var2) {
      byte[] var3 = null;
      Deque var4 = class237.field3215;
      synchronized(class237.field3215) {
         for(FileSystem var5 = (FileSystem)class237.field3215.getFront(); var5 != null; var5 = (FileSystem)class237.field3215.getNext()) {
            if((long)var0 == var5.hash && var1 == var5.index && var5.field3189 == 0) {
               var3 = var5.field3185;
               break;
            }
         }
      }

      if(var3 != null) {
         var2.method4207(var1, var0, var3, true);
      } else {
         byte[] var8 = var1.method3046(var0);
         var2.method4207(var1, var0, var8, true);
      }
   }

   @ObfuscatedName("jn")
   @ObfuscatedSignature(
      signature = "(IIIILkn;Lha;I)V",
      garbageValue = "1602057590"
   )
   static final void method4082(int var0, int var1, int var2, int var3, SpritePixels var4, class211 var5) {
      int var6 = var3 * var3 + var2 * var2;
      if(var6 > 4225 && var6 < 90000) {
         int var7 = Client.mapAngle & 2047;
         int var8 = Graphics3D.SINE[var7];
         int var9 = Graphics3D.COSINE[var7];
         int var10 = var9 * var2 + var3 * var8 >> 16;
         int var11 = var3 * var9 - var8 * var2 >> 16;
         double var12 = Math.atan2((double)var10, (double)var11);
         int var14 = (int)(Math.sin(var12) * 63.0D);
         int var15 = (int)(Math.cos(var12) * 57.0D);
         class60.mapedge.method5112(var0 + var14 + 94 + 4 - 10, var1 + 83 - var15 - 20, 20, 20, 15, 15, var12, 256);
      } else {
         class276.drawDot(var0, var1, var2, var3, var4, var5);
      }

   }

   @ObfuscatedName("hj")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2025871574"
   )
   static void method4085() {
      if(Client.spellSelected) {
         Widget var0 = class24.method183(class22.field347, Client.field1058);
         if(var0 != null && var0.field2735 != null) {
            ScriptEvent var1 = new ScriptEvent();
            var1.widget = var0;
            var1.field849 = var0.field2735;
            PendingSpawn.method1525(var1);
         }

         Client.spellSelected = false;
         class255.method4531(var0);
      }
   }
}
