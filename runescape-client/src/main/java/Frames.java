import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eu")
@Implements("Frames")
public class Frames extends CacheableNode {
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Ljr;"
   )
   @Export("ItemDefinition_modelIndexCache")
   static IndexDataBase ItemDefinition_modelIndexCache;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lgg;"
   )
   @Export("NetCache_responseArchiveBuffer")
   public static Buffer NetCache_responseArchiveBuffer;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "[Ldz;"
   )
   @Export("skeletons")
   Frame[] skeletons;

   @ObfuscatedSignature(
      signature = "(Ljr;Ljr;IZ)V"
   )
   Frames(IndexDataBase var1, IndexDataBase var2, int var3, boolean var4) {
      Deque var5 = new Deque();
      int var6 = var1.fileCount(var3);
      this.skeletons = new Frame[var6];
      int[] var7 = var1.getChilds(var3);

      for(int var8 = 0; var8 < var7.length; ++var8) {
         byte[] var9 = var1.getConfigData(var3, var7[var8]);
         FrameMap var10 = null;
         int var11 = (var9[0] & 255) << 8 | var9[1] & 255;

         for(FrameMap var12 = (FrameMap)var5.getFront(); var12 != null; var12 = (FrameMap)var5.getNext()) {
            if(var11 == var12.id) {
               var10 = var12;
               break;
            }
         }

         if(var10 == null) {
            byte[] var13;
            if(var4) {
               var13 = var2.getChild(0, var11);
            } else {
               var13 = var2.getChild(var11, 0);
            }

            var10 = new FrameMap(var11, var13);
            var5.addFront(var10);
         }

         this.skeletons[var7[var8]] = new Frame(var9, var10);
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "1600816356"
   )
   public boolean method3145(int var1) {
      return this.skeletons[var1].showing;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IB)Ljv;",
      garbageValue = "39"
   )
   @Export("getUnderlayDefinition")
   public static FloorUnderlayDefinition getUnderlayDefinition(int var0) {
      FloorUnderlayDefinition var1 = (FloorUnderlayDefinition)FloorUnderlayDefinition.underlays.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = FloorUnderlayDefinition.underlay_ref.getConfigData(1, var0);
         var1 = new FloorUnderlayDefinition();
         if(var2 != null) {
            var1.decode(new Buffer(var2), var0);
         }

         var1.post();
         FloorUnderlayDefinition.underlays.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-867111425"
   )
   public static void method3149() {
      KeyFocusListener var0 = KeyFocusListener.keyboard;
      synchronized(KeyFocusListener.keyboard) {
         ++KeyFocusListener.keyboardIdleTicks;
         KeyFocusListener.field627 = KeyFocusListener.field610;
         KeyFocusListener.field626 = 0;
         int var1;
         if(KeyFocusListener.field614 < 0) {
            for(var1 = 0; var1 < 112; ++var1) {
               KeyFocusListener.keyPressed[var1] = false;
            }

            KeyFocusListener.field614 = KeyFocusListener.field621;
         } else {
            while(KeyFocusListener.field614 != KeyFocusListener.field621) {
               var1 = KeyFocusListener.field612[KeyFocusListener.field621];
               KeyFocusListener.field621 = KeyFocusListener.field621 + 1 & 127;
               if(var1 < 0) {
                  KeyFocusListener.keyPressed[~var1] = false;
               } else {
                  if(!KeyFocusListener.keyPressed[var1] && KeyFocusListener.field626 < KeyFocusListener.field625.length - 1) {
                     KeyFocusListener.field625[++KeyFocusListener.field626 - 1] = var1;
                  }

                  KeyFocusListener.keyPressed[var1] = true;
               }
            }
         }

         if(KeyFocusListener.field626 > 0) {
            KeyFocusListener.keyboardIdleTicks = 0;
         }

         KeyFocusListener.field610 = KeyFocusListener.field628;
      }
   }
}
