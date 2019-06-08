import java.util.Comparator;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kf")
@Implements("AbstractUserComparator")
public abstract class AbstractUserComparator implements Comparator {
   @ObfuscatedName("f")
   @Export("__f")
   Comparator __f;

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Ljava/util/Comparator;B)V",
      garbageValue = "-2"
   )
   @Export("__e_460")
   final void __e_460(Comparator var1) {
      if(this.__f == null) {
         this.__f = var1;
      } else if(this.__f instanceof AbstractUserComparator) {
         ((AbstractUserComparator)this.__f).__e_460(var1);
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Ljs;Ljs;I)I",
      garbageValue = "-962181316"
   )
   @Export("__x_461")
   protected final int __x_461(User var1, User var2) {
      return this.__f == null?0:this.__f.compare(var1, var2);
   }

   @Export("__equals_462")
   @ObfuscatedName("equals")
   public boolean __equals_462(Object var1) {
      return super.equals(var1);
   }

   @ObfuscatedName("fu")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "2048322935"
   )
   static void method5437(int var0) {
      if(var0 == -1 && !Client.__client_qq) {
         class214.midiPcmStream.clear();
         class214.__hf_o = 1;
         class214.__hf_u = null;
      } else if(var0 != -1 && var0 != Client.__client_qy && Client.__client_qf != 0 && !Client.__client_qq) {
         IndexCache var1 = UserComparator3.indexCache6;
         int var2 = Client.__client_qf;
         class214.__hf_o = 1;
         class214.__hf_u = var1;
         class30.musicTrackArchiveId = var0;
         GrandExchangeOffer.musicTrackFileId = 0;
         WorldMapLabel.__aj_e = var2;
         RectangleMode.musicTrackBoolean = false;
         FaceNormal.__el_x = 2;
      }

      Client.__client_qy = var0;
   }
}
