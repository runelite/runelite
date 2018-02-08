import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jr")
public class class274 extends NameableContainer {
   @ObfuscatedName("ix")
   @ObfuscatedGetter(
      intValue = 861141069
   )
   static int field3702;
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lld;"
   )
   final JagexLoginType field3704;

   @ObfuscatedSignature(
      signature = "(Lld;)V"
   )
   public class274(JagexLoginType var1) {
      super(400);
      this.field3704 = var1;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)Ljq;",
      garbageValue = "-1161467535"
   )
   Nameable vmethod5308() {
      return new Ignore();
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(II)[Ljq;",
      garbageValue = "-1191416525"
   )
   Nameable[] vmethod5331(int var1) {
      return new Ignore[var1];
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lgy;II)V",
      garbageValue = "31963459"
   )
   public void method5159(Buffer var1, int var2) {
      while(true) {
         if(var1.offset < var2) {
            int var3 = var1.readUnsignedByte();
            boolean var4 = (var3 & 1) == 1;
            Name var5 = new Name(var1.readString(), this.field3704);
            Name var6 = new Name(var1.readString(), this.field3704);
            var1.readString();
            if(var5 != null && var5.method5276()) {
               Ignore var7 = (Ignore)this.method5173(var4?var6:var5);
               if(var7 != null) {
                  this.method5222(var7, var5, var6);
                  continue;
               }

               if(this.getCount() < 400) {
                  var7 = (Ignore)this.method5178(var5, var6);
               }
               continue;
            }

            throw new IllegalStateException();
         }

         return;
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Lir;II)Z",
      garbageValue = "-1287805086"
   )
   static boolean method5158(IndexDataBase var0, int var1) {
      byte[] var2 = var0.takeRecordFlat(var1);
      if(var2 == null) {
         return false;
      } else {
         class3.decodeSprite(var2);
         return true;
      }
   }
}
