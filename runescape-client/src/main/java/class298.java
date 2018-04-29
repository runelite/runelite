import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("km")
public class class298 extends NameableContainer {
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lly;"
   )
   final JagexLoginType field3839;

   @ObfuscatedSignature(
      signature = "(Lly;)V"
   )
   public class298(JagexLoginType var1) {
      super(400);
      this.field3839 = var1;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)Lkg;",
      garbageValue = "1778408778"
   )
   Nameable vmethod5513() {
      return new Ignore();
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IB)[Lkg;",
      garbageValue = "0"
   )
   Nameable[] vmethod5514(int var1) {
      return new Ignore[var1];
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Lgg;II)V",
      garbageValue = "-1784238502"
   )
   public void method5351(Buffer var1, int var2) {
      while(true) {
         if(var1.offset < var2) {
            int var3 = var1.readUnsignedByte();
            boolean var4 = (var3 & 1) == 1;
            Name var5 = new Name(var1.readString(), this.field3839);
            Name var6 = new Name(var1.readString(), this.field3839);
            var1.readString();
            if(var5 != null && var5.isCleanNameValid()) {
               Ignore var7 = (Ignore)this.method5368(var5);
               if(var4) {
                  Ignore var8 = (Ignore)this.method5368(var6);
                  if(var8 != null && var7 != var8) {
                     if(var7 != null) {
                        this.method5415(var8);
                     } else {
                        var7 = var8;
                     }
                  }
               }

               if(var7 != null) {
                  this.method5375(var7, var5, var6);
                  continue;
               }

               if(this.getCount() < 400) {
                  int var9 = this.getCount();
                  var7 = (Ignore)this.method5372(var5, var6);
                  var7.field3850 = var9;
               }
               continue;
            }

            throw new IllegalStateException();
         }

         return;
      }
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "-63"
   )
   public static final boolean method5361() {
      KeyFocusListener var0 = KeyFocusListener.keyboard;
      synchronized(KeyFocusListener.keyboard) {
         if(KeyFocusListener.field627 == KeyFocusListener.field610) {
            return false;
         } else {
            class303.currentPressedKey = KeyFocusListener.field624[KeyFocusListener.field627];
            BoundingBox2D.currentTypedKey = KeyFocusListener.field623[KeyFocusListener.field627];
            KeyFocusListener.field627 = KeyFocusListener.field627 + 1 & 127;
            return true;
         }
      }
   }
}
