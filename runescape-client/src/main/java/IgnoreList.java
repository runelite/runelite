import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kj")
@Implements("IgnoreList")
public class IgnoreList extends UserList {
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Llx;"
   )
   @Export("loginType")
   final LoginType loginType;

   @ObfuscatedSignature(
      signature = "(Llx;)V"
   )
   public IgnoreList(LoginType var1) {
      super(400);
      this.loginType = var1;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)Ljs;",
      garbageValue = "-2063112195"
   )
   User newInstance() {
      return new Ignored();
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(II)[Ljs;",
      garbageValue = "861814350"
   )
   User[] newTypedArray(int var1) {
      return new Ignored[var1];
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Lgr;IB)V",
      garbageValue = "32"
   )
   @Export("read")
   public void read(Buffer var1, int var2) {
      while(true) {
         if(var1.index < var2) {
            int var3 = var1.readUnsignedByte();
            boolean var4 = (var3 & 1) == 1;
            Username var5 = new Username(var1.readStringCp1252NullTerminated(), this.loginType);
            Username var6 = new Username(var1.readStringCp1252NullTerminated(), this.loginType);
            var1.readStringCp1252NullTerminated();
            if(var5 != null && var5.hasCleanName()) {
               Ignored var7 = (Ignored)this.getByCurrentUsername(var5);
               if(var4) {
                  Ignored var8 = (Ignored)this.getByCurrentUsername(var6);
                  if(var8 != null && var8 != var7) {
                     if(var7 != null) {
                        this.remove(var8);
                     } else {
                        var7 = var8;
                     }
                  }
               }

               if(var7 != null) {
                  this.changeName(var7, var5, var6);
                  continue;
               }

               if(this.size() < 400) {
                  int var9 = this.size();
                  var7 = (Ignored)this.addLast(var5, var6);
                  var7.id = var9;
               }
               continue;
            }

            throw new IllegalStateException();
         }

         return;
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;IZB)I",
      garbageValue = "5"
   )
   static int method5438(CharSequence var0, int var1, boolean var2) {
      if(var1 >= 2 && var1 <= 36) {
         boolean var3 = false;
         boolean var4 = false;
         int var5 = 0;
         int var6 = var0.length();

         for(int var7 = 0; var7 < var6; ++var7) {
            char var8 = var0.charAt(var7);
            if(var7 == 0) {
               if(var8 == '-') {
                  var3 = true;
                  continue;
               }

               if(var8 == '+') {
                  continue;
               }
            }

            int var10;
            if(var8 >= '0' && var8 <= '9') {
               var10 = var8 - '0';
            } else if(var8 >= 'A' && var8 <= 'Z') {
               var10 = var8 - '7';
            } else {
               if(var8 < 'a' || var8 > 'z') {
                  throw new NumberFormatException();
               }

               var10 = var8 - 'W';
            }

            if(var10 >= var1) {
               throw new NumberFormatException();
            }

            if(var3) {
               var10 = -var10;
            }

            int var9 = var10 + var5 * var1;
            if(var9 / var1 != var5) {
               throw new NumberFormatException();
            }

            var5 = var9;
            var4 = true;
         }

         if(!var4) {
            throw new NumberFormatException();
         } else {
            return var5;
         }
      } else {
         throw new IllegalArgumentException("");
      }
   }
}
