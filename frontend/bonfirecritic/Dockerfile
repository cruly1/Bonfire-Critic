FROM node:22-alpine

WORKDIR /frontend

COPY package.json package-lock.json ./

RUN npm install

COPY . .

EXPOSE 3000

ENTRYPOINT ["npm", "run", "start-watch"]